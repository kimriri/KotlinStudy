package com.example.kotlin_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /**
     * ctrl + G : 선택한 블록과 일치하는 text를 선택한다.
     * cmd + shift + [ or ] : tab 화면 전환
     * cmd + shift + backspace : 가장 최근에 수정한 코드 줄로 이동
     * */

    private lateinit var tvFirst: TextView
    private lateinit var tvSecond: TextView
    private lateinit var tvThird: TextView

    /**
     * lateinit var 나중에 사용할 때 초기화 하겟다.
     * 즉, 내가 언젠가 너에게 반드시 null이 아닌 값을 줄거야 라는 뜻이다.
     * 따라서 lateinit var nullable 한 타입에는 사용이 불가능 하다.
     */
    private lateinit var immutableList: List<String>

    private val mutableList: MutableList<String> by lazy { mutableListOf() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvFirst = findViewById(R.id.tv_first)
        tvSecond = findViewById(R.id.tv_second)
        tvThird = findViewById(R.id.tv_third)
        logicToCheckIsInitialized()

    }

    /**
     * lateinit var 로 선언된 변수의 초기화가 되었는지 안되었는지 확인 할 수있다.
     * 초기화가 안되아 있으면 초기화를 하면 된다.
     * */
    private fun logicToCheckIsInitialized() {
        if (::immutableList.isInitialized) {
            immutableList[0]
        } else {
            immutableList = mutableListOf()
        }

        /**
         * val by lazy 로 늦은 초기화를 한 변수는, 변수를 선언할 할 때 초기화를 반드시 해 주어야 하기 때문에
         * isInitialized 라는 함수를 사용 할 수 없다.
         */

        /**
        if(::someVariableTwo.isInitialized)
        {

        }*/
    }

    /**
     * 코틀린은 수정 가능한 변수와, 수정 불가능한 변수를 강하게 구분한다.
     * mutable 변수는 수정이 가능하고, immutable 변수는 수정이 불가능 하다.
     * var은, 변수 자체를 재할당을 허용 하지만, val은 변수 자체 재할당을 허용하지 않는다.
     * Kotlin 애서는 List 인터페이스에서는 add / remove 등과 같은 함수를 제공하지 않기 때문에, List 의 원소를 추가 / 삭제 할 수 없다.
     * 반면에, MutableList 인터페이스에는 add / remove 등과 같은 함수가 제공 되기 때문에 List 의 원소를 추가 / 삭제 할 수 있다.
     * List / MutableList 모두 Red 는 된다. Write 작업에 차이가 있다.
     * 그래서 List 라는 태입을 쓰는 경우는, 이 리스트가 변경 되지 않아야 할 때 List 를 쓴다.
     * List 를 MutableList 로 할당 하는 것은 가능 하지만 MutableList 를 List 로 할당 하는 것은 불가능 하다.
     */

    private fun logicToCheckMutable()
    {

        mutableList.add("string")
        mutableList.add("string2")
        mutableList[1]
       // immutableList.add("String")
    }
    /**
     * 과제
     * 1, 회사 코드에서 mutableList / List 활용 한 예시 코드를 여러개 찾아보기
     * 2, 1에서 찾은 코드 중에 어 이게 왜 mutable 변수인지 이게 왜 immutable 변수인지 먼가 이상한게 있으면 왜 이상한지 한번 생각해보고 수정 할 수 있으면 하기
     * 3, 오늘 썻던 단축키 한번 더 써보기
     * 4, var / val 이 쓰인 코드를 회사에서 찾아보고, 문제가 있으면 사수한테 물어보고 수정하기
     */
}