package com.aykutasil.navigationplayground.ui.main

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NotificationCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.aykutasil.navigationplayground.R
import com.aykutasil.navigationplayground.ui.about.AboutFragment
import kotlinx.android.synthetic.main.fragment_main.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigation için click kullanılacaksa @{Navigation.createNavigateOnClickListener} kısayol olarak kullanılabilir.
        // btnLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_loginFragment))

        // {Navigation.createNavigateOnClickListener} ile aynı
        btnLogin.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_loginFragment)
        }

        btnAbout.setOnClickListener {
            // şu an ki fragment dan başka bir fragment a geçiş sağlanırken 'androidx.navigation.safeargs' plugini kullanılarak type safe bir arguman
            // geçişi sağlanabilir. navigation graph içerisinde arg bekleyen fragment içerisine gerekli tanımlamalar yapılır.
            // tanımlama esnasında default val verilmez ise constructer da verilmesi zorunlu hale gelir.
            val action = MainFragmentDirections.action_mainFragment_to_aboutFragment("Asil")
            action.setAd("Aykut")
            Navigation.findNavController(it).navigate(action)
        }

        btnBlog.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_blogListFragment)
        }

        btnDeeplink.setOnClickListener {
            //val intent = Intent(Intent.ACTION_VIEW)
            //startActivity(intent)

            val args = Bundle()
            args.putString("myarg", "Aykut")
            val deeplink = Navigation.findNavController(it).createDeepLink()
                    .setDestination(R.id.deepLinkFragment)
                    .setArguments(args)
                    .createPendingIntent()

            val notificationManager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(NotificationChannel(
                        "deeplink", "Deep Links", NotificationManager.IMPORTANCE_HIGH))
            }
            val builder = NotificationCompat.Builder(
                    context!!, "deeplink")
                    .setContentTitle("Navigation")
                    .setContentText("Deep link to Android")
                    .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    .setContentIntent(deeplink)
                    .setAutoCancel(true)

            notificationManager.notify(0, builder.build())
        }


    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MainFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
