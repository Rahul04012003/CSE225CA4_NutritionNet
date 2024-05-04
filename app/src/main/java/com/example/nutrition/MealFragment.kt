package com.example.nutrition

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.io.IOException

class MealFragment : Fragment() {

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null

    private lateinit var imageViewPreview: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal, container, false)

        val editTextHeight: EditText = view.findViewById(R.id.editTextHeight)
        val editTextWeight: EditText = view.findViewById(R.id.editTextWeight)
        val buttonCalculateBMI: Button = view.findViewById(R.id.buttonCalculateBMI)
        val buttonUploadPictures: Button = view.findViewById(R.id.buttonUploadPictures)
        val textViewBMIResult: TextView = view.findViewById(R.id.textViewBMIResult)

        imageViewPreview = view.findViewById(R.id.imageViewPreview)

        buttonCalculateBMI.setOnClickListener {
            val heightStr = editTextHeight.text.toString()
            val weightStr = editTextWeight.text.toString()

            if (heightStr.isEmpty() || weightStr.isEmpty()) {
                Toast.makeText(context, "Please enter both height and weight", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height = heightStr.toDouble()
            val weight = weightStr.toDouble()

            val bmi = calculateBMI(height, weight)
            val targetBMI = calculateTargetBMI(height)

            textViewBMIResult.text = "Your BMI: $bmi\nTarget Weight by BMI: $targetBMI"
        }

        buttonUploadPictures.setOnClickListener {
            openFileChooser()
        }

        return view
    }

    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, selectedImageUri)
                imageViewPreview.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun calculateBMI(height: Double, weight: Double): Double {
        return weight / ((height / 100) * (height / 100))
    }

    private fun calculateTargetBMI(height: Double): Double {
        return 22 * ((height / 100) * (height / 100))
    }
}
