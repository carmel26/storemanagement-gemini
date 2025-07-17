package com.example.storemanagement.ui.productdetail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.storemanagement.R
import com.example.storemanagement.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    // Use navArgs to retrieve the product object passed from HomeFragment
    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        val product = args.product

        // Populate UI with product details
        binding.detailProductName.text = product.name
        binding.detailProductPrice.text = "$%.2f".format(product.price)
        binding.detailProductDescription.text = product.description

        // Set product image. In a real app, use Glide/Picasso for image URLs.
        val imageResId = binding.root.context.resources.getIdentifier(
            product.imageUrl, "drawable", binding.root.context.packageName
        )
        if (imageResId != 0) {
            binding.detailProductImage.setImageResource(imageResId)
        } else {
            // Fallback to a default icon if image not found
            binding.detailProductImage.setImageResource(R.drawable.ic_app_icon)
        }


        binding.detailAddToCartButton.setOnClickListener {
            Toast.makeText(context, "${product.name} added to cart!", Toast.LENGTH_SHORT).show()
            // Implement actual add to cart logic here
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}