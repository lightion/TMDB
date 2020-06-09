package tech.lightion.tmdb.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.lightion.tmdb.databinding.CardCastItemBinding
import tech.lightion.tmdb.extensions.loadImage
import tech.lightion.tmdb.model.Cast

class CastListAdapter(
    private val list: ArrayList<Cast>
) : RecyclerView.Adapter<CastListAdapter.CastListViewHolder>() {

    fun updateCast(newList: List<Cast>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardCastItemBinding.inflate(layoutInflater)
        return CastListViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CastListViewHolder, position: Int) {
        val cast = list[position]
        holder.bind(cast)
    }

    inner class CastListViewHolder (
        val binding: CardCastItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cast : Cast) {
            binding.cast = cast
            binding.castImageView.loadImage(cast.castImage)
            binding.executePendingBindings()
        }
    }
}