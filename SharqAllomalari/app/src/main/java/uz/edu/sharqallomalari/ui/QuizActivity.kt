package uz.edu.sharqallomalari.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import uz.edu.sharqallomalari.R
import uz.edu.sharqallomalari.data.QuizRepository
import uz.edu.sharqallomalari.databinding.ActivityQuizBinding
import uz.edu.sharqallomalari.databinding.DialogQuizResultBinding
import uz.edu.sharqallomalari.model.QuizQuestion

/**
 * Astronomiya bo'yicha 120 savoldan iborat testni o'tkazish ekrani.
 * Har bir savolda 4 variantdan biri tanlanadi, javobdan keyin
 * to'g'ri/noto'g'ri rang bilan belgilanadi va tushuntirish ko'rsatiladi.
 */
class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private val questions: List<QuizQuestion> = QuizRepository.questions.shuffled()

    private var currentIndex = 0
    private var correctCount = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        binding.btnNext.setOnClickListener {
            if (currentIndex == questions.size - 1) {
                showResultDialog()
            } else {
                currentIndex++
                showQuestion()
            }
        }

        showQuestion()
    }

    private fun showQuestion() {
        answered = false
        val question = questions[currentIndex]

        binding.tvProgress.text = getString(
            R.string.quiz_progress_format, currentIndex + 1, questions.size
        )
        binding.tvScore.text = getString(R.string.quiz_score_format, correctCount)
        binding.progressBar.progress = ((currentIndex) * 100) / questions.size

        binding.tvQuestion.text = question.question
        binding.tvExplanation.visibility = android.view.View.GONE
        binding.btnNext.isEnabled = false
        binding.btnNext.text = if (currentIndex == questions.size - 1) {
            getString(R.string.quiz_finish)
        } else {
            getString(R.string.quiz_next)
        }

        binding.containerOptions.removeAllViews()
        question.options.forEachIndexed { index, optionText ->
            val button = MaterialButton(this).apply {
                text = optionText
                isAllCaps = false
                textSize = 14f
                gravity = android.view.Gravity.START or android.view.Gravity.CENTER_VERTICAL
                setPadding(48, 32, 48, 32)
                layoutParams = android.widget.LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 24 }
                cornerRadius = 28
                strokeWidth = 2
                strokeColor = android.content.res.ColorStateList.valueOf(
                    ContextCompat.getColor(this@QuizActivity, R.color.outline)
                )
                setBackgroundColor(ContextCompat.getColor(this@QuizActivity, R.color.surface))
                setTextColor(ContextCompat.getColor(this@QuizActivity, R.color.text_primary))
            }
            button.setOnClickListener {
                if (!answered) {
                    onOptionSelected(question, index, button)
                }
            }
            binding.containerOptions.addView(button)
        }
    }

    private fun onOptionSelected(question: QuizQuestion, selectedIndex: Int, selectedButton: MaterialButton) {
        answered = true
        val isCorrect = selectedIndex == question.correctIndex
        if (isCorrect) correctCount++

        binding.tvScore.text = getString(R.string.quiz_score_format, correctCount)

        for (i in 0 until binding.containerOptions.childCount) {
            val btn = binding.containerOptions.getChildAt(i) as MaterialButton
            val color = when {
                i == question.correctIndex -> R.color.field_medicine
                i == selectedIndex && !isCorrect -> R.color.field_history
                else -> R.color.outline
            }
            btn.strokeColor = android.content.res.ColorStateList.valueOf(
                ContextCompat.getColor(this, color)
            )
            btn.strokeWidth = if (i == question.correctIndex || i == selectedIndex) 6 else 2
            btn.isEnabled = false
        }

        binding.tvExplanation.text = getString(
            R.string.quiz_correct_answer_format, question.options[question.correctIndex]
        )
        binding.tvExplanation.visibility = android.view.View.VISIBLE
        binding.btnNext.isEnabled = true
    }

    private fun showResultDialog() {
        val dialogBinding = DialogQuizResultBinding.inflate(layoutInflater)
        val percent = (correctCount * 100) / questions.size

        dialogBinding.tvResultEmoji.text = "$percent%"
        dialogBinding.tvResultDetail.text = getString(
            R.string.quiz_result_detail_format, questions.size, correctCount
        )
        dialogBinding.tvResultTitle.text = when {
            percent >= 80 -> getString(R.string.quiz_result_excellent)
            percent >= 50 -> getString(R.string.quiz_result_good)
            else -> getString(R.string.quiz_result_average)
        }

        val dialog = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .create()

        dialogBinding.btnRestart.setOnClickListener {
            dialog.dismiss()
            currentIndex = 0
            correctCount = 0
            showQuestion()
        }
        dialogBinding.btnClose.setOnClickListener {
            dialog.dismiss()
            finish()
        }

        dialog.show()
    }
}
