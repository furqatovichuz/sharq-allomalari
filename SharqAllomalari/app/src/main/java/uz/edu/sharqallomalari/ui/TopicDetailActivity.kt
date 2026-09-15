package uz.edu.sharqallomalari.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import uz.edu.sharqallomalari.data.TopicRepository
import uz.edu.sharqallomalari.databinding.ActivityTopicDetailBinding
import uz.edu.sharqallomalari.databinding.ItemTopicQuestionBinding

/**
 * Tanlangan mavzuning to'liq matnini, tayanch tushunchalarini va
 * nazorat savollarini ko'rsatuvchi ekran.
 */
class TopicDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopicDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topicId = intent.getIntExtra(EXTRA_TOPIC_ID, -1)
        val topic = TopicRepository.getById(topicId)
        if (topic == null) {
            finish()
            return
        }

        binding.toolbar.title = "${topic.id}-MAVZU"
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        binding.tvTitle.text = topic.title
        binding.tvKeywords.text = topic.keywords.joinToString(", ")
        binding.tvContent.text = topic.paragraphs.joinToString("\n\n")

        binding.containerQuestions.removeAllViews()
        topic.controlQuestions.forEachIndexed { index, questionText ->
            val itemBinding = ItemTopicQuestionBinding.inflate(
                LayoutInflater.from(this), binding.containerQuestions, false
            )
            itemBinding.tvIndex.text = "${index + 1}."
            itemBinding.tvText.text = questionText
            binding.containerQuestions.addView(itemBinding.root)
        }
    }

    companion object {
        const val EXTRA_TOPIC_ID = "extra_topic_id"
    }
}
