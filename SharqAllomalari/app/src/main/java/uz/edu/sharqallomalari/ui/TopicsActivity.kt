package uz.edu.sharqallomalari.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.edu.sharqallomalari.adapter.TopicAdapter
import uz.edu.sharqallomalari.data.TopicRepository
import uz.edu.sharqallomalari.databinding.ActivityTopicsBinding
import uz.edu.sharqallomalari.model.Topic

/**
 * O'quv qo'llanmasidagi 9 ta mavzuning ro'yxatini ko'rsatuvchi ekran.
 */
class TopicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        val adapter = TopicAdapter(TopicRepository.topics) { topic ->
            openDetail(topic)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun openDetail(topic: Topic) {
        val intent = Intent(this, TopicDetailActivity::class.java)
        intent.putExtra(TopicDetailActivity.EXTRA_TOPIC_ID, topic.id)
        startActivity(intent)
    }
}
