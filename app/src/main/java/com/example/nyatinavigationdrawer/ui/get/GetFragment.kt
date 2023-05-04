package com.example.nyatinavigationdrawer.ui.get

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nyatinavigationdrawer.R
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.example.nyatinavigationdrawer.ApiHelper
import org.json.JSONArray


class GetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_get, container, false)
        val progressbar=view.findViewById<ProgressBar>(R.id.progressbar)
        val empdata=view.findViewById<TextView>(R.id.empdata)
//        define the api
        val api="https://sofwaredev.pythonanywhere.com/employees"
        //justpaste.it/4j6                              1p
        //access apiHelper
        val helper= ApiHelper(requireContext())
        helper.get(api, object : ApiHelper.CallBack {
            override fun onSuccess(result: String?) {
                //convert the results form GET into JSON Array
                val employeeJSONArray=JSONArray(result.toString()) //contains all the records from Db
                //Loop each object in the JSONArray
                (0 until employeeJSONArray.length()).forEach{
                    val employee=employeeJSONArray.getJSONObject(it)
                    //for each detail/info about the employee ,get the textview and append the 5 columns
                    empdata.append("ID: " +employee.get("id_number")+"\n")
                    empdata.append("Username : " +employee.get("username")+"\n")
                    empdata.append("Others : " +employee.get("others")+"\n")
                    empdata.append("Salary : " +employee.get("salary")+"\n")
                    empdata.append("Department : " +employee.get("department")+"\n")
                    empdata.append("\n\n")
                } //end of loop
                progressbar.visibility=View.GONE



            }

        })
        return view
    }
}