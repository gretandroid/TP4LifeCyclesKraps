package education.cccp.craps

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import education.cccp.craps.R.drawable.*
import education.cccp.craps.R.id.*
import education.cccp.craps.R.layout.activity_main
import kotlin.random.Random.Default.nextInt


@Suppress("unused")
class MainActivity : AppCompatActivity() {

    companion object {
        private const val DICE_MIN_VALUE: Int = 1
        private const val DICE_MAX_VALUE: Int = 6
        private const val CURRENT_DICES_STATE_KEY = "current_dices_state"
        private val diceResIds = intArrayOf(
            dice_face_one,
            dice_face_two,
            dice_face_three,
            dice_face_four,
            dice_face_five,
            dice_face_six,
        )
        private val randomDiceValueGenerator
            get() = diceResIds[nextInt(
                DICE_MIN_VALUE,
                DICE_MAX_VALUE
            )]
        private val currentDiceState: IntArray by lazy {
            intArrayOf(diceResIds.first(), diceResIds.first())
        }
    }

    private val firstDiceImageView: ImageView by lazy {
        findViewById(firstDiceImageViewId)
    }

    private val secondDiceImageView: ImageView by lazy {
        findViewById(secondDiceImageViewId)
    }
    private val rollDicesButton: Button by lazy {
        findViewById(rollDicesButtonId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        Log.d(
            "currentState onCreate",
            currentDiceState.toList().toString()
        )
    }

    fun onClickRollDicesButtonEvent(view: View) {
        firstDiceImageView.setImageResource(
            randomDiceValueGenerator.apply {
                currentDiceState[0] = this
            })
        secondDiceImageView.setImageResource(
            randomDiceValueGenerator.apply {
                currentDiceState[1] = this
            })
        Log.d(
            "currentState onclickButton",
            currentDiceState.toList().toString()
        )
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(
            CURRENT_DICES_STATE_KEY,
            currentDiceState
        )
    }
}