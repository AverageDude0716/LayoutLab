package com.example.layoutlab

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FirebaseFunctions {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = Firebase.firestore

    //login function
    fun loginUser(email: String, password: String, onComplete: (Boolean, String?) -> Unit){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    onComplete(true, null)
                }else{
                    onComplete(false, task.exception?.message)
                }
            }
    }


    // Register function
    fun registerUser(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)
                } else {
                    onComplete(false, task.exception?.message)
                }
            }
    }

    // save User data
    suspend fun saveUserData(collection: String, data: Map<String, Any>): Boolean {
        return suspendCoroutine { continuation ->
            firestore.collection(collection).add(data)
                .addOnSuccessListener {
                    continuation.resume(true)
                }
                .addOnFailureListener {
                    continuation.resume(false)
                }
        }
    }
}