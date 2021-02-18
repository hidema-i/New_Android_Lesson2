package android.example.rock_paper_scissors_game

import android.content.Intent
import android.example.rock_paper_scissors_game.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.View
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import java.util.prefs.PreferenceChangeEvent

class MainActivity : AppCompatActivity() {
    //1.View binding用の設定
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2.View binding用の設定
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //イメージボタンと作成したonJankenButtonTappedを紐付ける
        binding.gu.setOnClickListener { onJankenButtonTapped(it) }
        binding.choki.setOnClickListener { onJankenButtonTapped(it) }
        binding.pa.setOnClickListener { onJankenButtonTapped(it) }


        var pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit{
            clear()
        }

    }

    fun onJankenButtonTapped(view: View?) {     //3.　じゃんけんのボタン3つを設定し、引数でViewを受け取る※Null安全が保証されていないので？をつける
        val intent = Intent(this, ResultActivity::class.java)   //4.開きたいアクティビティを指定してintentをインスタンス生成
        intent.putExtra("MY_HAND",view?.id)
        startActivity(intent)   //5.4.をstartActivityメソッドを引数に渡す。

    }
}

