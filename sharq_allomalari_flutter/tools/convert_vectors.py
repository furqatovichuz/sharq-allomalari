#!/usr/bin/env python3
"""Converts Android VectorDrawable XML files to SVG files."""
import os
import re
import xml.etree.ElementTree as ET

ANDROID_NS = "{http://schemas.android.com/apk/res/android}"

SRC_DRAWABLE = r"E:\Flutter\Projects\SharqAllomalari\SharqAllomalari\app\src\main\res\drawable"
OUT_PORTRAITS = r"E:\Flutter\Projects\SharqAllomalari\sharq_allomalari_flutter\assets\portraits"
OUT_ICONS = r"E:\Flutter\Projects\SharqAllomalari\sharq_allomalari_flutter\assets\icons"


def a(elem, name, default=None):
    return elem.get(ANDROID_NS + name, default)


def convert_path(elem):
    path_data = a(elem, "pathData")
    fill_color = a(elem, "fillColor")
    stroke_color = a(elem, "strokeColor")
    stroke_width = a(elem, "strokeWidth")

    attrs = [f'd="{path_data}"']
    if fill_color:
        if fill_color == "#00000000":
            attrs.append('fill="none"')
        else:
            attrs.append(f'fill="{fill_color}"')
    else:
        attrs.append('fill="none"')

    if stroke_color and stroke_color != "#00000000":
        attrs.append(f'stroke="{stroke_color}"')
        if stroke_width:
            attrs.append(f'stroke-width="{stroke_width}"')

    return f"  <path {' '.join(attrs)} />"


def convert_group(elem, indent="  "):
    lines = []
    for child in elem:
        tag = child.tag.split("}")[-1]
        if tag == "path":
            lines.append(convert_path(child))
        elif tag == "group":
            lines.extend(convert_group(child, indent))
    return lines


def convert_file(src_path, dst_path):
    tree = ET.parse(src_path)
    root = tree.getroot()

    width = a(root, "width", "24dp").replace("dp", "")
    height = a(root, "height", "24dp").replace("dp", "")
    viewport_w = a(root, "viewportWidth", width)
    viewport_h = a(root, "viewportHeight", height)

    body_lines = []
    for child in root:
        tag = child.tag.split("}")[-1]
        if tag == "path":
            body_lines.append(convert_path(child))
        elif tag == "group":
            body_lines.extend(convert_group(child))

    svg = (
        f'<svg xmlns="http://www.w3.org/2000/svg" '
        f'width="{width}" height="{height}" '
        f'viewBox="0 0 {viewport_w} {viewport_h}">\n'
        + "\n".join(body_lines)
        + "\n</svg>\n"
    )

    with open(dst_path, "w", encoding="utf-8") as f:
        f.write(svg)


def main():
    os.makedirs(OUT_PORTRAITS, exist_ok=True)
    os.makedirs(OUT_ICONS, exist_ok=True)

    converted = []
    for fname in sorted(os.listdir(SRC_DRAWABLE)):
        if not fname.endswith(".xml"):
            continue
        src_path = os.path.join(SRC_DRAWABLE, fname)
        # Skip non-vector drawables (shape/layer-list backgrounds handled separately in Dart code).
        with open(src_path, "r", encoding="utf-8") as f:
            content = f.read()
        if "<vector" not in content:
            continue

        base = fname[:-4]
        svg_name = base + ".svg"
        if base.startswith("portrait_scholar_"):
            dst = os.path.join(OUT_PORTRAITS, svg_name)
        else:
            dst = os.path.join(OUT_ICONS, svg_name)

        convert_file(src_path, dst)
        converted.append((fname, dst))

    print(f"Converted {len(converted)} vector drawables:")
    for src, dst in converted:
        print(f"  {src} -> {dst}")


if __name__ == "__main__":
    main()
