package com.example.polkedex.screens.pokemon

import android.R
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.polkedex.model.Abilities
import com.example.polkedex.model.Pokemon
import com.example.polkedex.model.Stats
import com.example.polkedex.model.Types

class PokemonViewModule: ViewModel() {
    private val _id = MutableLiveData<String>("")
    private val _name = MutableLiveData<String>("")
    private val _image = MutableLiveData<String>("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/454.png")
    private val _description = MutableLiveData<String>("")
    private val _height = MutableLiveData<Int>(0)
    private val _weight = MutableLiveData<Int>(0)
    private val _abilities = MutableLiveData<List<Abilities>>()
    private val _stats = MutableLiveData<List<Stats>>()
    private val _types = MutableLiveData<List<Types>>()

    var id: LiveData<String> = _id
    var name: LiveData<String> = _name
    var image: LiveData<String> = _image
    var description: LiveData<String> = _description
    var height: LiveData<Int> = _height
    var weight: LiveData<Int> = _weight
    var abilities: LiveData<List<Abilities>> = _abilities
    var stats: LiveData<List<Stats>> = _stats
    var types: LiveData<List<Types>> = _types

    fun atulizarDados(pokemon: Pokemon){
        _id.value = pokemon.id
        _name.value = pokemon.name
        _image.value = pokemon.image
        _description.value = pokemon.description
        _height.value = pokemon.height
        _weight.value = pokemon.weight
        _abilities.value = pokemon.abilities
        _stats.value = pokemon.stats
        _types.value = pokemon.types

        Log.d("TAG", "${_id.value}")
        Log.d("TAG", "${_name.value}")
        Log.d("TAG", "${_image.value}")
        Log.d("TAG", "$_description")
        Log.d("TAG", "$_height")
        Log.d("TAG", "$_weight")
    }


//    fun atulizarDados(){
//        _id.value = "022"
//        _name.value = "teste"
//        _image.value = "sdasfasf"
//        _description.value = "asdasd"
//        _height.value = 1
//        _weight.value = 1
////        _abilities.value = "asdasd"
////        _stats.value = "asdasd"
////        _types.value = "asdasd"
//    }
}