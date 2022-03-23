package education.cccp.craps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {


    private val firstDiceImageView: ImageView by lazy {
        findViewById(R.id.firstDiceImageViewId)
    }
    private val secondDiceImageView: ImageView by lazy {
        findViewById(R.id.secondDiceImageViewId)
    }
    private val rollDicesButton: Button by lazy {
        findViewById(R.id.rollDicesButtonId)
    }

    private val diceResIds = intArrayOf(
        R.drawable.dice_face_one,
        R.drawable.dice_face_two,
        R.drawable.dice_face_three,
        R.drawable.dice_face_four,
        R.drawable.dice_face_five,
        R.drawable.dice_face_six,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickRollDicesButtonEvent(view: View) {
        firstDiceImageView.setImageResource(diceResIds[nextInt(1, 6)])
        secondDiceImageView.setImageResource(diceResIds[nextInt(1, 6)])
    }
}