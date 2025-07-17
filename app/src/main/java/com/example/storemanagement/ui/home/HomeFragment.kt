package com.example.storemanagement.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.storemanagement.R
import com.example.storemanagement.data.Product
import com.example.storemanagement.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupNextProductsButton()

        return root
    }

    private fun setupRecyclerView() {
        // Create a list of dummy products (replace with real data from a backend)
        val products = listOf(
            Product("1", "Stylish T-Shirt", 25.99, "product_tshirt", "Comfortable and trendy t-shirt for everyday wear."),
            Product("2", "Denim Jeans", 49.99, "product_jeans", "Classic denim jeans, perfect fit and durable."),
            Product("3", "Running Shoes", 75.00, "product_shoes", "Lightweight running shoes for optimal performance."),
            Product("4", "Leather Wallet", 30.50, "product_wallet", "Premium leather wallet with multiple card slots."),
            Product("5", "Smartwatch", 199.99, "product_smartwatch", "Stay connected with this feature-rich smartwatch."),
            Product("6", "Wireless Earbuds", 89.99, "product_earbuds", "High-quality sound and comfortable fit."),
            Product("7", "Backpack", 39.99, "product_backpack", "Spacious and durable backpack for daily use."),
            Product("8", "Coffee Maker", 60.00, "product_coffeemaker", "Brew your perfect cup of coffee at home."),
            Product("9", "Gaming Headset", 55.00, "product_headset", "Immersive sound for an enhanced gaming experience."),
            Product("10", "Desk Lamp", 22.00, "product_desklamp", "Modern desk lamp with adjustable brightness."),
            Product("11", "Yoga Mat", 20.00, "product_yogamat", "Non-slip yoga mat for comfortable workouts."),
            Product("12", "Water Bottle", 15.00, "product_waterbottle", "Insulated water bottle to keep drinks cold/hot.")
        )

        val adapter = ProductAdapter(products.take(10)) { product ->
            // Handle product click: navigate to product detail fragment
            val action = HomeFragmentDirections.actionHomeToProductDetailFragment(product)
            findNavController().navigate(action)
        }
        binding.productsRecyclerView.adapter = adapter
        // GridLayoutManager is already set in XML, but can be set here too:
        // binding.productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
    }

    private fun setupNextProductsButton() {
        binding.btnNextProducts.setOnClickListener {
            Toast.makeText(context, "Loading more products...", Toast.LENGTH_SHORT).show()
            // In a real app, you would load more products here and update the adapter.
            // For now, it's just a placeholder.
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}