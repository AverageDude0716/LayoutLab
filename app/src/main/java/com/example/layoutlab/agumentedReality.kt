package com.example.layoutlab

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.ArCoreApk
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.core.Session
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class agumentedReality : AppCompatActivity() {

    private lateinit var arFragment: ArFragment
    private val CAMERA_REQUEST_CODE = 1000 // Define a constant for the request code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agumented_reality)

        arFragment = supportFragmentManager.findFragmentById(R.id.arFragment) as ArFragment

        // Check camera permissions
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        } else {
            initializeArSession() // Initialize AR session if permission is already granted
        }

        arFragment.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane, motionEvent ->
            if (plane.type != Plane.Type.HORIZONTAL_UPWARD_FACING) {
                return@setOnTapArPlaneListener
            }

            // Load the 3D model
            ModelRenderable.builder()
                .setSource(this, R.raw.chair2) // Replace 'chair' with your .sfb model filename
                .build()
                .thenAccept { renderable ->
                    // Create anchor and place the model
                    val anchor = hitResult.createAnchor()
                    val anchorNode = AnchorNode(anchor)
                    anchorNode.setParent(arFragment.arSceneView.scene)

                    val node = TransformableNode(arFragment.transformationSystem)
                    node.renderable = renderable
                    node.setParent(anchorNode)
                    node.select()
                }
                .exceptionally {
                    // Handle model loading error
                    Log.e("ARModel", "Error loading model", it)
                    null
                }
        }
    }

    // Initialize AR session
    private fun initializeArSession() {
        val arCoreAvailability = ArCoreApk.getInstance().checkAvailability(this)

        if (arCoreAvailability.isTransient) {
            Toast.makeText(this, "Waiting for ARCore availability...", Toast.LENGTH_SHORT).show()
            return
        }

        if (arCoreAvailability != ArCoreApk.Availability.SUPPORTED_INSTALLED) {
            Toast.makeText(this, "ARCore is not supported on this device.", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        // The AR session is handled by ArFragment, no need to create or setup a session manually
        // Just ensure your fragment is set up correctly
        arFragment.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane, motionEvent ->
            if (plane.type != Plane.Type.HORIZONTAL_UPWARD_FACING) {
                return@setOnTapArPlaneListener
            }

            // Load the 3D model
            ModelRenderable.builder()
                .setSource(this, R.raw.chair2) // Ensure the model file name is correct
                .build()
                .thenAccept { renderable ->
                    // Create anchor and place the model
                    val anchor = hitResult.createAnchor()
                    val anchorNode = AnchorNode(anchor)
                    anchorNode.setParent(arFragment.arSceneView.scene)

                    val node = TransformableNode(arFragment.transformationSystem)
                    node.renderable = renderable
                    node.setParent(anchorNode)
                    node.select()
                }
                .exceptionally { throwable ->
                    Log.e("ARModel", "Error loading model: ${throwable.message}", throwable)
                    null
                }
        }
    }

    // Handle permission request results
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeArSession() // Re-initialize AR session after permission granted
            } else {
                Toast.makeText(this, "Camera permission is required for AR.", Toast.LENGTH_SHORT).show()
                finish() // Exit the app if permission is denied
            }
        }
    }

    // Override lifecycle methods for AR session
    override fun onResume() {
        super.onResume()
        arFragment.arSceneView.resume()
    }

    override fun onPause() {
        super.onPause()
        arFragment.arSceneView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        arFragment.arSceneView.destroy()
    }
}
