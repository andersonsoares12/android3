import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mundoti.rickandortyvideo.databinding.RickMortyLayoutBinding

class RickMortyAdapter :
    PagingDataAdapter<RickMorty, RickMortyAdapter.RickMortyViewHolder>(diffCallback) {

    inner class RickMortyViewHolder(private val binding: RickMortyLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RickMorty?) {
            val currentItem = getItem(position)
            item?.let { rickMorty ->
                binding.apply {
                    imageView.load(rickMorty.image)
                    textView.text = "${currentItem?.name}"
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        val binding =
            RickMortyLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickMortyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean =
                oldItem == newItem
        }
    }
}
