package com.example.supplydashboardapp

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import java.util.Date


class MainActivity : Activity() {
    private val productList = ArrayList<Product>()
    private val datePicked = Date()
    private val categories = listOf("Category 1", "Category 2", "Category 3")

    private lateinit var lvProducts: ListView
    private lateinit var addButton: Button
    private lateinit var sendButton: Button
    private lateinit var dateButton: Button
    private lateinit var categorySpinner: Spinner
    private lateinit var nameEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        lvProducts = findViewById(R.id.listViewProducts)
        addButton = findViewById(R.id.addButton)
        sendButton = findViewById(R.id.sendButton)
        dateButton = findViewById(R.id.btPickDate)
        categorySpinner = findViewById(R.id.categorySpinner)
        nameEditText = findViewById(R.id.nameEditText)

        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        categorySpinner.adapter = categoryAdapter

        val listViewAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productList)
        lvProducts.adapter = listViewAdapter

        addButton.setOnClickListener {
            onAddButtonClick()
        }

        sendButton.setOnClickListener {
            // TODO: Send the productList to an API endpoint
            onSendButtonClick()
        }
    }

    private fun clearInputFields() {
        nameEditText.setText("")
        hideKeyboard()
    }

    private fun clearListView() {
        // TODO: Implement Listview clear
    }

    private fun onAddButtonClick() {
        val name = nameEditText.text.toString()
        val date = datePicked
        val category = categorySpinner.selectedItem.toString()
        val product = Product(name, date, category)
        productList.add(product)
        clearInputFields()
    }

    private fun onSendButtonClick() {
        // TODO: Handle send to API Endpoint when Server is available. Save if not available for later sending
        clearInputFields()
        clearListView()
    }

    private fun hideKeyboard(){
        try{
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(
                addButton.getWindowToken(),
                InputMethodManager.RESULT_UNCHANGED_SHOWN
            )
        }
        catch (e: Exception){

        }
    }

}
