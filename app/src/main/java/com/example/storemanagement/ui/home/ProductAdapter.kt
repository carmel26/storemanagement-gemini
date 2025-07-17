package com.example.storemanagement.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.storemanagement.R
import com.example.storemanagement.data.Product
import com.example.storemanagement.databinding.ItemProductBinding

class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productName.text = product.name
            binding.productPrice.text = "$%.2f".format(product.price)

            // Set product image. In a real app, use Glide/Picasso for image URLs.
            // For now, we'll use a placeholder or a simple drawable if imageUrl matches a drawable name.
            val imageResId = binding.root.context.resources.getIdentifier(
                product.imageUrl, "drawable", binding.root.context.packageName
            )
            if (imageResId != 0) {
                binding.productImage.setImageResource(imageResId)
            } else {
                // Fallback to a default icon if image not found
                binding.productImage.setImageResource(R.drawable.ic_app_icon)
            }


            // Handle click on the entire product card
            binding.root.setOnClickListener {
                onItemClick(product)
            }

            // Handle "Add to Cart" button click
            binding.addToCartButton.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${product.name} added to cart!",
                    Toast.LENGTH_SHORT
                ).show()
                // Implement actual add to cart logic here (e.g., update a ViewModel, save to DB)
            }
        }
    }
}