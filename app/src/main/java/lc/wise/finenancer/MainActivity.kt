package lc.wise.finenancer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lc.wise.finenancer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //TODO: add toolbar for back and settings button
    }
}