package edu.neu.khoury.madsea.majianqing

interface UpdateandDelete{

    fun modifyItem(item:UserEntity)
    fun onItemDelete(item:UserEntity)
    fun onItemEdit(item:UserEntity)
}