package com.trung.cvapplication.work.worklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.trung.cvapplication.R
import com.trung.cvapplication.model.remote.Work
import com.trung.cvapplication.network.APIClient
import kotlinx.android.synthetic.main.fragment_work_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 */
class WorkListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_work_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callNetwork()
    }

    private fun callNetwork() {
        // Make Network call from the client to retrieve hit requested data
        var call = APIClient.apiInterface().getWorks()
        /* Asynchronously send the request and notify of its response or if an error
   * occurred talking to the server, creating the request, or processing the response.
   */
        call.enqueue(object : Callback<List<Work>> { // Make a call to hit the server
            // hit if you receive the response--> which is to retrieve the List of ImageData
            override fun onResponse(call: Call<List<Work>?>?, response: Response<List<Work>?>?) {
                if( response!!.isSuccessful){ // Check using non null !! operator
                    // The deserialized response body of a successful response ie List<Animals>
                    setRecyclerView(response.body()!!)
                }
            }
            // Unable to get a response
            override fun onFailure(call: Call<List<Work>?>?, t: Throwable?) {
                // The localized description of this throwable, like getErrorMessage from throwable
                Toast.makeText(requireContext(),"An Error Occured  ${t?.localizedMessage}", Toast.LENGTH_LONG).show()

            }

        })

    }

    private fun setRecyclerView(works : List<Work>) {
        listWork.layoutManager = LinearLayoutManager(context)
        listWork.adapter = WorkAdapter(works)

    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkListFragment()
    }
}