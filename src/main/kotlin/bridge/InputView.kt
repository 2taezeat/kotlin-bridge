package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(READ_BRIDGE_SIZE_PRINT)
        val userInput = Console.readLine()
        if (!bridgeSizeIsValid(userInput)) {
            throw IllegalArgumentException(READ_BRIDGE_SIZE_ERROR_MESSAGE)
        }
        return userInput.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(READ_MOVING_PRINT)
        val userInput = Console.readLine()
        if (!movingInputIsValid(userInput)) {
            throw IllegalArgumentException(READ_MOVING_ERROR_MESSAGE)
        }
        return userInput
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(READ_GAME_COMMAND_PRINT)
        val userInput = Console.readLine()
        if (!gameCommandInputIsValid(userInput)) {
            throw IllegalArgumentException(READ_GAME_COMMAND_ERROR_MESSAGE)
        }
        return userInput
    }


    private fun bridgeSizeIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) return false
        if (!isNumber(userInput)) return false
        if (userInput.toInt() !in BRIDGE_MIN_SIZE..BRIDGE_MAX_SIZE) return false
        return true
    }


    private fun movingInputIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) return false
        if (userInput != Moving.UP.getMovDirection() && userInput != Moving.DOWN.getMovDirection()) return false
        return true
    }

    private fun gameCommandInputIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) return false
        if (userInput != GameCommand.RESTART.getGameCommand() && userInput != GameCommand.QUIT.getGameCommand()) return false
        return true
    }


    private fun isNumber(elementString: String): Boolean {
        return try {
            elementString.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }


    companion object {
        const val READ_BRIDGE_SIZE_PRINT = "다리의 길이를 입력해주세요."
        const val READ_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3이상 20이하의 숫자를 입력해야 합니다."
        const val BRIDGE_MAX_SIZE = 20
        const val BRIDGE_MIN_SIZE = 3

        const val READ_MOVING_PRINT = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val READ_MOVING_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U(위 칸) 또는 D(아래 칸) 중 하나여야 합니다."

        const val READ_GAME_COMMAND_PRINT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        const val READ_GAME_COMMAND_ERROR_MESSAGE = "[ERROR] 게임 재시작/종료 입력은 R(재시도) 또는 Q(종료) 중 하나여야 합니다."
    }


}
