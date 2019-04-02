package com.linderaredux.utils


class FragmentHistory {

    private var stackArr: ArrayList<Int> = ArrayList()

    /**
     * This method adds new entry to the top
     * of the stack
     *
     * @param entry
     * @throws Exception
     */
    fun push(entry: Int) {

        if (isAlreadyExists(entry)) {
            return
        }
        stackArr.add(entry)

    }

    private fun isAlreadyExists(entry: Int): Boolean {
        return stackArr.contains(entry)
    }

    /**
     * This method removes an entry from the
     * top of the stack.
     *
     * @return
     * @throws Exception
     */
    fun pop(): Int {

        var entry = -1
        if (!isEmpty()) {

            entry = stackArr[stackArr.size - 1]

            stackArr.remove(stackArr.size - 1)
        }
        return entry
    }


    /**
     * This method removes an entry from the
     * top of the stack.
     *
     * @return
     * @throws Exception
     */
    fun popPrevious(): Int {

        var entry = -1

        if (!isEmpty()) {
            entry = stackArr[stackArr.size - 2]
            stackArr.remove(stackArr.size - 2)
        }
        return entry
    }


    /**
     * This method returns top of the stack
     * without removing it.
     *
     * @return
     */
    fun peek(): Int {
        return if (!isEmpty()) {
            stackArr[stackArr.size - 1]
        } else -1

    }


    fun isEmpty(): Boolean {
        return stackArr.size === 0
    }


    fun getStackSize(): Int {
        return stackArr.size
    }

    fun emptyStack() {

        stackArr.clear()
    }
}