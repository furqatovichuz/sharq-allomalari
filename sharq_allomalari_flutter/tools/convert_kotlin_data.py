#!/usr/bin/env python3
"""Mechanically converts the Kotlin data-repository files into Dart source.

The Kotlin literal syntax used in these files (named-arg constructor calls,
listOf(...) calls, triple-quoted trimIndent() strings) is close enough to
Dart's own literal syntax that a small tokenizing transform can carry the
data across losslessly, without retyping ~1500 lines by hand.
"""
import os
import re

SRC_DIR = r"E:\Flutter\Projects\SharqAllomalari\SharqAllomalari\app\src\main\java\uz\edu\sharqallomalari\data"
OUT_DIR = r"E:\Flutter\Projects\SharqAllomalari\sharq_allomalari_flutter\lib\data"

ENUM_MAP = {
    "ASTRONOMY": "ScholarCategory.astronomy",
    "MATHEMATICS": "ScholarCategory.mathematics",
    "MEDICINE": "ScholarCategory.medicine",
    "HISTORY": "ScholarCategory.history",
    "STATE": "ScholarCategory.state",
}


def strip_kotlin_comments_and_imports(src: str) -> str:
    lines = src.split("\n")
    out = []
    in_block_comment = False
    for line in lines:
        if in_block_comment:
            if "*/" in line:
                in_block_comment = False
            continue
        stripped = line.strip()
        if stripped.startswith("/*"):
            if "*/" not in line:
                in_block_comment = True
            continue
        if stripped.startswith("package ") or stripped.startswith("import "):
            continue
        out.append(line)
    return "\n".join(out)


def tokenize_and_transform(src: str) -> str:
    # Walks the source char by char, aware of Kotlin string literals, and:
    # - swaps matching parens of listOf(...) calls to [...]
    # - converts triple-quoted trimIndent() blocks to escaped Dart strings
    # - converts named-args (name = value) to Dart's (name: value)
    # - maps R.drawable.xxx paths and bare enum constants
    i = 0
    n = len(src)
    out = []
    paren_stack = []  # stack of bools: True if this '(' belongs to a listOf( we opened

    while i < n:
        ch = src[i]

        # Triple-quoted string
        if src.startswith('"""', i):
            end = src.find('"""', i + 3)
            assert end != -1, "Unterminated triple-quoted string"
            content = src[i + 3:end]
            i = end + 3
            # consume optional .trimIndent()
            rest = src[i:]
            m = re.match(r"\s*\.trimIndent\(\)", rest)
            if m:
                i += m.end()
            dart_literal = dedent_to_dart_string(content)
            out.append(dart_literal)
            continue

        # Regular double-quoted string (handle escapes)
        if ch == '"':
            j = i + 1
            buf = ['"']
            while j < n:
                if src[j] == "\\" and j + 1 < n:
                    buf.append(src[j])
                    buf.append(src[j + 1])
                    j += 2
                    continue
                if src[j] == '"':
                    buf.append('"')
                    j += 1
                    break
                buf.append(src[j])
                j += 1
            out.append("".join(buf))
            i = j
            continue

        # line comment
        if src.startswith("//", i):
            end = src.find("\n", i)
            if end == -1:
                end = n
            i = end
            continue

        # listOf(
        m = re.match(r"listOf\(", src[i:])
        if m:
            out.append("[")
            paren_stack.append(True)
            i += m.end()
            continue

        if ch == "(":
            paren_stack.append(False)
            out.append(ch)
            i += 1
            continue

        if ch == ")":
            is_list = paren_stack.pop() if paren_stack else False
            out.append("]" if is_list else ")")
            i += 1
            continue

        # identifier (word) - check for named-arg ` = ` or enum constant or R.drawable
        wm = re.match(r"[A-Za-z_][A-Za-z0-9_]*", src[i:])
        if wm:
            word = wm.group(0)
            after = src[i + len(word):]
            # named-arg pattern: identifier followed by optional spaces then '=' (not '==')
            am = re.match(r"[ \t]*=(?!=)[ \t]*", after)
            if am:
                out.append(word + ": ")
                i += len(word) + am.end()
                continue
            if word in ENUM_MAP:
                out.append(ENUM_MAP[word])
                i += len(word)
                continue
            # R.drawable.portrait_scholar_NN or R.drawable.ic_xxx
            if word == "R":
                rm = re.match(r"R\.drawable\.([A-Za-z0-9_]+)", src[i:])
                if rm:
                    asset = rm.group(1)
                    if asset.startswith("portrait_scholar_"):
                        out.append(f"'assets/portraits/{asset}.svg'")
                    else:
                        out.append(f"'assets/icons/{asset}.svg'")
                    i += rm.end()
                    continue
            out.append(word)
            i += len(word)
            continue

        out.append(ch)
        i += 1

    return "".join(out)


def dedent_to_dart_string(content: str) -> str:
    lines = content.split("\n")
    # Drop leading/trailing pure-whitespace lines (trimIndent behavior)
    while lines and lines[0].strip() == "":
        lines.pop(0)
    while lines and lines[-1].strip() == "":
        lines.pop()

    indents = [len(l) - len(l.lstrip(" ")) for l in lines if l.strip() != ""]
    common = min(indents) if indents else 0
    dedented = [l[common:] if len(l) >= common else l for l in lines]
    text = "\n".join(dedented)

    escaped = (
        text.replace("\\", "\\\\")
        .replace("$", "\\$")
        .replace('"', '\\"')
        .replace("\n", "\\n")
    )
    return f'"{escaped}"'


DART_HEADER = """// GENERATED from Kotlin source via tools/convert_kotlin_data.py
// Do not hand-edit generated list bodies; re-run the script instead.

"""


def convert_scholar_repository():
    src = read_stripped("ScholarRepository.kt")
    body = tokenize_and_transform(src)
    m = re.search(r"val scholars: List<Scholar> = (\[.*?\n    \])", body, re.S)
    list_literal = m.group(1)
    count = list_literal.count("Scholar(\n")
    out = DART_HEADER + (
        "import '../models/scholar.dart';\n\n"
        "class ScholarRepository {\n"
        "  ScholarRepository._();\n\n"
        f"  static final List<Scholar> scholars = {list_literal};\n\n"
        "  static Scholar? getById(int id) {\n"
        "    for (final s in scholars) {\n"
        "      if (s.id == id) return s;\n"
        "    }\n"
        "    return null;\n"
        "  }\n\n"
        "  static List<Scholar> getByCategory(ScholarCategory? category) {\n"
        "    if (category == null) return scholars;\n"
        "    return scholars.where((s) => s.categories.contains(category)).toList();\n"
        "  }\n"
        "}\n"
    )
    write_out("scholar_repository.dart", out)
    return count


def convert_observatory_repository():
    src = read_stripped("ObservatoryRepository.kt")
    body = tokenize_and_transform(src)
    m = re.search(r"val observatories: List<Observatory> = (\[.*?\n    \])", body, re.S)
    list_literal = m.group(1)
    count = list_literal.count("Observatory(\n")
    out = DART_HEADER + (
        "import '../models/observatory.dart';\n\n"
        "class ObservatoryRepository {\n"
        "  ObservatoryRepository._();\n\n"
        f"  static final List<Observatory> observatories = {list_literal};\n\n"
        "  static Observatory? getById(int id) {\n"
        "    for (final o in observatories) {\n"
        "      if (o.id == id) return o;\n"
        "    }\n"
        "    return null;\n"
        "  }\n"
        "}\n"
    )
    write_out("observatory_repository.dart", out)
    return count


def convert_topic_repository():
    src = read_stripped("TopicRepository.kt")
    body = tokenize_and_transform(src)
    m = re.search(r"val topics: List<Topic> = (\[.*?\n    \])", body, re.S)
    list_literal = m.group(1)
    count = list_literal.count("Topic(\n")
    out = DART_HEADER + (
        "import '../models/topic.dart';\n\n"
        "class TopicRepository {\n"
        "  TopicRepository._();\n\n"
        f"  static final List<Topic> topics = {list_literal};\n\n"
        "  static Topic? getById(int id) {\n"
        "    for (final t in topics) {\n"
        "      if (t.id == id) return t;\n"
        "    }\n"
        "    return null;\n"
        "  }\n"
        "}\n"
    )
    write_out("topic_repository.dart", out)
    return count


def convert_quiz_repository():
    src = read_stripped("QuizRepository.kt")
    body = tokenize_and_transform(src)
    m = re.search(r"val questions: List<QuizQuestion> = (\[.*?\n    \])", body, re.S)
    list_literal = m.group(1)
    count = list_literal.count("QuizQuestion(")
    out = DART_HEADER + (
        "import '../models/quiz_question.dart';\n\n"
        "class QuizRepository {\n"
        "  QuizRepository._();\n\n"
        f"  static final List<QuizQuestion> questions = {list_literal};\n"
        "}\n"
    )
    write_out("quiz_repository.dart", out)
    return count


def convert_glossary_repository():
    src = read_stripped("GlossaryRepository.kt")
    body = tokenize_and_transform(src)
    m = re.search(r"val terms: List<GlossaryTerm> = (\[.*?\n    \])", body, re.S)
    list_literal = m.group(1)
    count = list_literal.count("GlossaryTerm(")
    out = DART_HEADER + (
        "import '../models/glossary_term.dart';\n\n"
        "class GlossaryRepository {\n"
        "  GlossaryRepository._();\n\n"
        f"  static final List<GlossaryTerm> terms = {list_literal};\n"
        "}\n"
    )
    write_out("glossary_repository.dart", out)
    return count


def read_stripped(fname: str) -> str:
    with open(os.path.join(SRC_DIR, fname), "r", encoding="utf-8") as f:
        return strip_kotlin_comments_and_imports(f.read())


def write_out(fname: str, content: str):
    path = os.path.join(OUT_DIR, fname)
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"wrote {path}")


def main():
    counts = {
        "scholars": convert_scholar_repository(),
        "observatories": convert_observatory_repository(),
        "topics": convert_topic_repository(),
        "quiz_questions": convert_quiz_repository(),
        "glossary_terms": convert_glossary_repository(),
    }
    print("Counts:", counts)
    expected = {"scholars": 13, "observatories": 5, "topics": 9, "quiz_questions": 120, "glossary_terms": 46}
    for k, v in expected.items():
        status = "OK" if counts[k] == v else "MISMATCH"
        print(f"  {k}: expected {v}, got {counts[k]} -> {status}")


if __name__ == "__main__":
    main()
