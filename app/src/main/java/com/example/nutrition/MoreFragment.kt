package com.example.nutrition

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

class MoreFragment : Fragment() {

    private lateinit var selectedCalendar: Calendar
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_more, container, false)

        val selectDateButton: Button = view.findViewById(R.id.selectDateButton)
        val selectTimeButton: Button = view.findViewById(R.id.selectTimeButton)
        val setAlarmButton: Button = view.findViewById(R.id.setAlarmButton)
        val passwordButton: Button = view.findViewById(R.id.passwordButton)

        selectedCalendar = Calendar.getInstance()
        sharedPreferences = requireActivity().getSharedPreferences("Login", Context.MODE_PRIVATE)

        selectDateButton.setOnClickListener {
            showDatePicker()
        }

        selectTimeButton.setOnClickListener {
            showTimePicker()
        }

        setAlarmButton.setOnClickListener {
            setAlarm()
        }

        passwordButton.setOnClickListener {
            showStoredCredentials()
        }

        return view
    }

    private fun showDatePicker() {
        val datePicker = DatePickerDialog(requireContext(), { _, year, month, day ->
            selectedCalendar.set(Calendar.YEAR, year)
            selectedCalendar.set(Calendar.MONTH, month)
            selectedCalendar.set(Calendar.DAY_OF_MONTH, day)
            Toast.makeText(requireContext(), "Date selected: $day/${month + 1}/$year", Toast.LENGTH_SHORT).show()
        }, selectedCalendar.get(Calendar.YEAR), selectedCalendar.get(Calendar.MONTH), selectedCalendar.get(Calendar.DAY_OF_MONTH))
        datePicker.show()
    }

    private fun showTimePicker() {
        val timePicker = TimePickerDialog(requireContext(), { _, hourOfDay, minute ->
            selectedCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            selectedCalendar.set(Calendar.MINUTE, minute)
            Toast.makeText(requireContext(), "Time selected: $hourOfDay:$minute", Toast.LENGTH_SHORT).show()
        }, selectedCalendar.get(Calendar.HOUR_OF_DAY), selectedCalendar.get(Calendar.MINUTE), true)
        timePicker.show()
    }

    private fun setAlarm() {
        // Implement set alarm logic here
        val dateTime = selectedCalendar.timeInMillis
        Toast.makeText(requireContext(), "Alarm set for: ${selectedCalendar.time}", Toast.LENGTH_SHORT).show()
    }

    private fun showStoredCredentials() {
        val username = sharedPreferences.getString("username", "No username found")
        val password = sharedPreferences.getString("password", "No password found")
        Toast.makeText(requireContext(), "Username: $username\nPassword: $password", Toast.LENGTH_LONG).show()
    }
}
