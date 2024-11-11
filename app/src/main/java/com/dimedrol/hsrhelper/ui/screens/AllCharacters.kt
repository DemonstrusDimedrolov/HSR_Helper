package com.dimedrol.hsrhelper.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dimedrol.hsrhelper.data.Character
import com.dimedrol.hsrhelper.ui.recomposition.CharacterCard
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

@Composable
fun AllCharacters() {
    val firestore = FirebaseFirestore.getInstance()
    val characters = remember { mutableStateOf<List<Character>>(emptyList()) }

    LaunchedEffect(Unit) {
        firestore.collection("Characters")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    characters.value = snapshot.documents.mapNotNull {
                        it.toObject<Character>()
                    }
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(characters.value.size) { component ->
                val character = characters.value[component]
                CharacterCard(
                    character.name,
                    character.image_url,
                    character.element,
                    character.rare
                )
            }
        }
    }
}