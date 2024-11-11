package com.dimedrol.hsrhelper.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dimedrol.hsrhelper.data.MenuItemData
import com.dimedrol.hsrhelper.ui.recomposition.MenuItem
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.selects.whileSelect

@Composable
fun MenuScreen(
    paddingValues: PaddingValues,
    onNavigateToAllCharacters: () -> Unit,
    onNavigateToAllCone: () -> Unit,
    onNavigateToAllRelics: () -> Unit
) {
    val firestore = FirebaseFirestore.getInstance()
    val menuItems = remember { mutableStateOf<List<MenuItemData>>(emptyList()) }

    LaunchedEffect(Unit) {
        firestore.collection("MenuItems")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Log.e("FirestoreError", "Error fetching menu items", e)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    menuItems.value = snapshot.documents.mapNotNull { it.toObject<MenuItemData>() }
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        menuItems.value.forEachIndexed { index, item ->
            MenuItem(item.url, item.description) {
                when (index) {
                    0 -> onNavigateToAllCharacters()
                    1 -> onNavigateToAllCone()
                    2 -> onNavigateToAllRelics()
                }
            }
        }
    }
}