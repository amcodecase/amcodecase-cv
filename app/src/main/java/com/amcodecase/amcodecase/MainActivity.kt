package com.amcodecase.amcodecase

import android.os.Bundle
import androidx.compose.material.icons.*
import androidx.compose.material.icons.outlined.DeveloperBoard
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.unit.dp
import android.content.Intent
import android.net.Uri
import android.content.Context
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.material.icons.outlined.WorkspacePremium
//import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.Brightness7
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.Dialog
import androidx.compose.material.AlertDialogBuilder
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amcodecase.amcodecase.ui.theme.AmcodecaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEntryPoint()
        }
    }
}

@Composable
fun AppEntryPoint() {
    var isDarkTheme by remember { mutableStateOf(false) }

    AmcodecaseTheme(darkTheme = isDarkTheme) {
        Surface(modifier = Modifier.fillMaxSize()) {
            TechProfileApp(
                isDarkTheme = isDarkTheme,
                onThemeToggle = { isDarkTheme = !isDarkTheme }
            )
        }
    }
}

@Composable
fun TechProfileApp(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    // Define a better color palette that works in both light/dark themes
    val primaryColor = Color(0xFF4E1A5B)     // Russian Violet (primary)
    val secondaryColor = Color(0xFF3A0C78)    // Deep Purple (darker blue-purple)
    val accentColor = Color(0xFF8F3985)       // Plum (brighter purple-pink)

// Background and surface colors
    val backgroundColor = if (isDarkTheme) Color(0xFF121212) else Color(0xFFF5F7FA)
    val surfaceColor = if (isDarkTheme) Color(0xFF1E1E1E) else Color.White
    val textPrimaryColor = if (isDarkTheme) Color.White else Color(0xFF2D3748)
    val textSecondaryColor = if (isDarkTheme) Color.White.copy(alpha = 0.7f) else Color(0xFF718096)

// Additional purple shades
    val purplePalette = mapOf(
        "russianVioletLight" to Color(0xFF6A2A7B),   // Lighter Russian Violet
        "russianVioletDark" to Color(0xFF35123F),    // Darker Russian Violet
        "lavender" to Color(0xFF9C7CA8),            // Soft lavender
        "deepPlum" to Color(0xFF762A68),            // Deep plum
        "amethyst" to Color(0xFF6D38C4),            // Amethyst purple
        "orchid" to Color(0xFFB667D9),              // Orchid purple
        "mauve" to Color(0xFF9B69AB)                // Mauve
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backgroundColor,
        floatingActionButton = {
            ThemeSwitchFAB(isDarkTheme = isDarkTheme, onThemeToggle = onThemeToggle)
        }
    ) { innerPadding ->
        ProfileScreen(
//            modifier = Modifier.padding(innerPadding),
            primaryColor = primaryColor,
            secondaryColor = secondaryColor,
            accentColor = accentColor,
            backgroundColor = backgroundColor,
            surfaceColor = surfaceColor,
            textPrimaryColor = textPrimaryColor,
            textSecondaryColor = textSecondaryColor,
            isDarkTheme = isDarkTheme
        )
    }
}

@Composable
fun ThemeSwitchFAB(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    FloatingActionButton(
        onClick = onThemeToggle,
        containerColor = if (isDarkTheme) Color(0xFF3A0CA3) else Color(0xFF4361EE),
        contentColor = Color.White,
        shape = CircleShape
    ) {
        Icon(
            imageVector = if (isDarkTheme) Icons.Default.Brightness7 else Icons.Default.Brightness4,
            contentDescription = if (isDarkTheme) "Switch to Light Theme" else "Switch to Dark Theme",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    primaryColor: Color,
    secondaryColor: Color,
    accentColor: Color,
    backgroundColor: Color,
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf(
        TabItem("Profile", Icons.Default.Person),
        TabItem("Skills", Icons.Default.Build),
        TabItem("Career", Icons.Default.DateRange),
        TabItem("Awards", Icons.Default.Star)
    )

    val scrollState = rememberScrollState()

    Column(modifier = modifier.fillMaxSize()) {
        // Header - NO PADDING applied here
        ProfileHeader(
            primaryColor = primaryColor,
            secondaryColor = secondaryColor,
            textColor = Color.White,
            isDarkTheme = isDarkTheme
        )

        // Rest of the content can have padding
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            // Tabs with better styling and contrast
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = surfaceColor,
                contentColor = primaryColor,
                divider = { Divider(thickness = 2.dp, color = primaryColor.copy(alpha = 0.1f)) },
                modifier = Modifier.fillMaxWidth()
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        text = {
                            Text(
                                text = tab.title,
                                fontWeight = if (selectedTabIndex == index) FontWeight.SemiBold else FontWeight.Medium,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        },
                        selectedContentColor = primaryColor,
                        unselectedContentColor = textSecondaryColor.copy(alpha = 0.7f)
                    )
                }
            }

            // Content area with proper scrolling
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(vertical = 16.dp)
            ) {
                when (selectedTabIndex) {
                    0 -> ProfileContent(
                        primaryColor = primaryColor,
                        secondaryColor = secondaryColor,
                        accentColor = accentColor,
                        surfaceColor = surfaceColor,
                        textPrimaryColor = textPrimaryColor,
                        textSecondaryColor = textSecondaryColor,
                        isDarkTheme = isDarkTheme
                    )
                    1 -> SkillsContent(
                        primaryColor = primaryColor,
                        secondaryColor = secondaryColor,
                        accentColor = accentColor,
                        surfaceColor = surfaceColor,
                        textPrimaryColor = textPrimaryColor,
                        textSecondaryColor = textSecondaryColor,
                        isDarkTheme = isDarkTheme
                    )
                    2 -> CareerContent(
                        primaryColor = primaryColor,
                        secondaryColor = secondaryColor,
                        accentColor = accentColor,
                        surfaceColor = surfaceColor,
                        textPrimaryColor = textPrimaryColor,
                        textSecondaryColor = textSecondaryColor,
                        isDarkTheme = isDarkTheme
                    )
                    3 -> AwardsContent(
                        primaryColor = primaryColor,
                        secondaryColor = secondaryColor,
                        accentColor = accentColor,
                        surfaceColor = surfaceColor,
                        textPrimaryColor = textPrimaryColor,
                        textSecondaryColor = textSecondaryColor,
                        isDarkTheme = isDarkTheme
                    )
//                    else -> ComingSoonContent(
//                        tabName = tabs[selectedTabIndex].title,
//                        primaryColor = primaryColor,
//                        accentColor = accentColor,
//                        surfaceColor = surfaceColor,
//                        textPrimaryColor = textPrimaryColor,
//                        textSecondaryColor = textSecondaryColor
//                    )
                }
            }
        }
    }
}
@Composable
fun ProfileHeader(
    primaryColor: Color,
    secondaryColor: Color,
    textColor: Color,
    isDarkTheme: Boolean
) {
    // For the triple-tap detection
    var tapCount by remember { mutableStateOf(0) }
    var lastTapTime by remember { mutableStateOf(0L) }
    val context = LocalContext.current

    // State for showing the alert dialog
    var showCoffeeDialog by remember { mutableStateOf(false) }

    // Reset tap count after delay
    LaunchedEffect(tapCount) {
        if (tapCount > 0) {
            delay(500) // Reset after 500ms if no more taps
            tapCount = 0
        }
    }

    // Coffee confirmation dialog
    if (showCoffeeDialog) {
        AlertDialog(
            onDismissRequest = { showCoffeeDialog = false },
            title = { Text("Coffee Time!") },
            text = { Text("You have promised to buy me coffee... you know what to do!") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showCoffeeDialog = false
                        // Launch Airtel Money after confirmation
                        launchAirtelMoney(context)
                    }
                ) {
                    Text("Let's do it!")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showCoffeeDialog = false }
                ) {
                    Text("Maybe later")
                }
            },
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.primary,
            textContentColor = MaterialTheme.colorScheme.onSurface
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .drawBehind {
                // Background grid and dots pattern
                val lineColor = Color.White.copy(alpha = 0.05f)
                val dotColor = Color.White.copy(alpha = 0.08f)
                val spacing = 20f

                // Draw grid lines
                for (x in 0..size.width.toInt() step spacing.toInt()) {
                    drawLine(
                        color = lineColor,
                        start = Offset(x.toFloat(), 0f),
                        end = Offset(x.toFloat(), size.height),
                        strokeWidth = 0.5f
                    )
                }

                for (y in 0..size.height.toInt() step spacing.toInt()) {
                    drawLine(
                        color = lineColor,
                        start = Offset(0f, y.toFloat()),
                        end = Offset(size.width, y.toFloat()),
                        strokeWidth = 0.5f
                    )
                }

                // Draw dots at intersections
                for (x in 0..size.width.toInt() step (spacing * 2).toInt()) {
                    for (y in 0..size.height.toInt() step (spacing * 2).toInt()) {
                        drawCircle(
                            color = dotColor,
                            radius = 1.5f,
                            center = Offset(x.toFloat(), y.toFloat())
                        )
                    }
                }
            }
    ) {
        // Background gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(primaryColor, secondaryColor)
                    )
                )
        )

        // Tech icons background pattern
        TechIconsBackground()

        // Content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp)) // This will push everything below it

            // Profile image with triple tap detection
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .shadow(8.dp, CircleShape)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(1.dp)
                    .clickable {
                        val currentTime = System.currentTimeMillis()
                        if (currentTime - lastTapTime < 500) {
                            tapCount++

                            // Check for triple tap
                            if (tapCount == 3) {
                                // Show the coffee dialog instead of launching directly
                                showCoffeeDialog = true
                                // Reset after successful trigger
                                tapCount = 0
                            }
                        } else {
                            // First tap or tap after timeout
                            tapCount = 1
                        }
                        lastTapTime = currentTime
                    },
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    primaryColor.copy(alpha = 0.2f),
                                    primaryColor.copy(alpha = 0.3f)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.pfp),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Michelo M Justus",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = textColor,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                color = textColor.copy(alpha = 0.2f),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, textColor.copy(alpha = 0.3f))
            ) {
                val context = LocalContext.current

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            // Create WhatsApp intent
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse("https://api.whatsapp.com/send?phone=260770822430")
                            }
                            // Check if WhatsApp is installed
                            if (intent.resolveActivity(context.packageManager) != null) {
                                context.startActivity(intent)
                            } else {
                                // If WhatsApp is not installed, open the browser
                                val browserIntent = Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://api.whatsapp.com/send?phone=260770822430"))
                                context.startActivity(browserIntent)
                            }
                        }
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = null,
                        tint = textColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = "amcodecase - The Modern Day Developer",
                        style = MaterialTheme.typography.bodyMedium,
                        color = textColor,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}

// Function to launch Airtel Money or show fallback
fun launchAirtelMoney(context: Context) {
    val airtelPackage = "com.airtel.africa.selfcare"
    val isAirtelInstalled = try {
        context.packageManager.getPackageInfo(airtelPackage, 0)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }

    if (isAirtelInstalled) {
        // Launch Airtel Money app
        val launchIntent = context.packageManager.getLaunchIntentForPackage(airtelPackage)
        if (launchIntent != null) {
            context.startActivity(launchIntent)
        }
    } else {
        // Show fallback message
        Toast.makeText(
            context,
            "Airtel Money app not installed. You can still buy me a coffee via USSD.",
            Toast.LENGTH_LONG
        ).show()

        // Optional: Launch USSD code
        try {
            val ussdCode = "*115#"
            val ussdIntent = Intent(Intent.ACTION_CALL)
            ussdIntent.data = Uri.parse("tel:$ussdCode")
            context.startActivity(ussdIntent)
        } catch (e: Exception) {
            // Handle exceptions (like missing CALL permission)
            Toast.makeText(
                context,
                "Couldn't launch USSD code. Please dial *115# manually.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
// Function to launch Airtel Money or show fallback
fun launchAirtelMoney(context: Context) {
    val airtelPackage = "com.airtel.africa.selfcare"
    val isAirtelInstalled = try {
        context.packageManager.getPackageInfo(airtelPackage, 0)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }

    if (isAirtelInstalled) {
        // Launch Airtel Money app
        val launchIntent = context.packageManager.getLaunchIntentForPackage(airtelPackage)
        if (launchIntent != null) {
            context.startActivity(launchIntent)
        }
    } else {
        // Show fallback message
        Toast.makeText(
            context,
            "Airtel Money app not installed. You can still buy me a coffee via USSD.",
            Toast.LENGTH_LONG
        ).show()

        // Optional: Launch USSD code
        try {
            val ussdCode = "*115#"
            val ussdIntent = Intent(Intent.ACTION_CALL)
            ussdIntent.data = Uri.parse("tel:$ussdCode")
            context.startActivity(ussdIntent)
        } catch (e: Exception) {
            // Handle exceptions (like missing CALL permission)
            Toast.makeText(
                context,
                "Couldn't launch USSD code. Please dial *115# manually.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Composable
fun TechIconsBackground() {
    // Define the tech icons
    val techIcons = listOf(
        Icons.Outlined.Laptop,
        Icons.Outlined.Headset,
        Icons.Outlined.Usb,
        Icons.Outlined.Memory,
        Icons.Outlined.Router,
        Icons.Outlined.Settings,
        Icons.Outlined.Code,
        Icons.Outlined.DeviceHub,
        Icons.Outlined.DeveloperBoard,
        Icons.Outlined.Smartphone,
        Icons.Outlined.Watch,
        Icons.Outlined.Keyboard,
        Icons.Outlined.Mouse,
        Icons.Outlined.Storage,
        Icons.Outlined.Devices
    )

    // Create a fixed pattern of icons with their positions
    val positions = listOf(
        Pair(0.1f, 0.15f),
        Pair(0.85f, 0.2f),
        Pair(0.25f, 0.75f),
        Pair(0.75f, 0.65f),
        Pair(0.4f, 0.3f),
        Pair(0.6f, 0.85f),
        Pair(0.15f, 0.45f),
        Pair(0.9f, 0.55f),
        Pair(0.3f, 0.9f),
        Pair(0.7f, 0.1f),
        Pair(0.5f, 0.5f),
        Pair(0.2f, 0.6f),
        Pair(0.8f, 0.4f),
        Pair(0.45f, 0.7f),
        Pair(0.65f, 0.25f)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Draw tech icons with different opacity levels
        positions.forEachIndexed { index, (xPercent, yPercent) ->
            Icon(
                imageVector = techIcons[index % techIcons.size],
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.09f), // Very faded
                modifier = Modifier
                    .size(((index % 3 + 1) * 24).dp) // Different sizes for variety (24dp, 48dp, 72dp)
                    .align(Alignment.TopStart)
                    .offset(
                        x = (xPercent * 400).dp - 24.dp, // Adjust based on parent width
                        y = (yPercent * 240).dp - 24.dp  // Adjust based on parent height
                    )
            )
        }
    }
}
@Composable
fun ProfileContent(
    primaryColor: Color,
    secondaryColor: Color,
    accentColor: Color,
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        // About me section
        AboutMeCard(
            surfaceColor = surfaceColor,
            textPrimaryColor = textPrimaryColor,
            textSecondaryColor = textSecondaryColor,
            isDarkTheme = isDarkTheme
        )

        // Tech expertise section
        SkillDistributionSection(
            primaryColor = primaryColor,
            secondaryColor = secondaryColor,
            accentColor = accentColor,
            surfaceColor = surfaceColor,
            textPrimaryColor = textPrimaryColor,
            textSecondaryColor = textSecondaryColor,
            isDarkTheme = isDarkTheme
        )

        // Personal info card
        ProfileInfoCard(
            primaryColor = primaryColor,
            surfaceColor = surfaceColor,
            textPrimaryColor = textPrimaryColor,
            textSecondaryColor = textSecondaryColor
        )

        // Stats section
        StatsSection(
            primaryColor = primaryColor,
            secondaryColor = secondaryColor,
            accentColor = accentColor,
            textPrimaryColor = textPrimaryColor,
            textSecondaryColor = textSecondaryColor,
            isDarkTheme = isDarkTheme
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun AboutMeCard(
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = surfaceColor)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "About Me",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = textPrimaryColor,
                letterSpacing = 1.sp
            )

            Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

            Text(
                text = "I am a software developer with hands-on experience across web and mobile applications, networking, embedded systems, and cybersecurity. My focus is on building clean, efficient, and sustainable systems.",
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 24.sp,
                color = textPrimaryColor,
                textAlign = TextAlign.Justify
            )

            Text(
                text = "I am deeply committed to structure, user experience, and solving real-world problems, particularly in the fields of education and tech accessibility. My experience spans software development, networking, and low-level hardware integration.",
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 24.sp,
                color = textPrimaryColor,
                textAlign = TextAlign.Justify
            )

            Text(
                text = "Beyond development, I am passionate about ethical hacking, digital forensics like data recovery, and empowering others in the tech community whether students, fellow developers, or aspiring engineers. I learn quickly, build purposefully, and continuously strive for progress.",
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 24.sp,
                color = textPrimaryColor,
                textAlign = TextAlign.Justify
            )
        }
    }
}


@Composable
fun SkillDistributionSection(
    primaryColor: Color,
    secondaryColor: Color,
    accentColor: Color,
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    // Updated skill distribution values based on percentage
    val softwareDev = 0.35f
    val cybersecurity = 0.20f
    val embeddedSystems = 0.15f
    val tutoring = 0.10f
    val networking = 0.08f
    val generalSkills = 0.07f
    val other = 0.05f

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = surfaceColor)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Psychology,
                        contentDescription = null,
                        tint = primaryColor,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "SKILLSET DISTRIBUTION",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = primaryColor,
                        letterSpacing = 1.sp
                    )
                }
                Text(
                    text = "100%",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = accentColor
                )
            }

            Text(
                text = "What you're looking at:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = textPrimaryColor
            )

            Text(
                text = "This is not simply a display of skills, it is a structured representation of how my expertise is distributed. " +
                        "Each area reflects a deliberate focus, illustrating where I invest my time, effort, and mastery. " +
                        "Together, these areas form a complete picture of my professional capacity, my full 100%.",
                style = MaterialTheme.typography.bodyMedium,
                color = textSecondaryColor,
                textAlign = TextAlign.Justify
            )

            // Advanced skill meter with animated colors and percentage indicators
            SkillMeterItem(
                icon = Icons.Outlined.DeveloperBoard,
                title = "Software Development",
                progress = softwareDev,
                percentage = "35%",
                color = primaryColor,
                textColor = textPrimaryColor
            )

            SkillMeterItem(
                icon = Icons.Default.Security,
                title = "Cybersecurity",
                progress = cybersecurity,
                percentage = "20%",
                color = secondaryColor,
                textColor = textPrimaryColor
            )

            SkillMeterItem(
                icon = Icons.Outlined.Memory,
                title = "Embedded Systems",
                progress = embeddedSystems,
                percentage = "15%",
                color = accentColor,
                textColor = textPrimaryColor
            )

            SkillMeterItem(
                icon = Icons.Default.School,
                title = "Educational Services (Teaching, etc.)",
                progress = tutoring,
                percentage = "10%",
                color = Color(0xFF8BC34A),
                textColor = textPrimaryColor
            )

            SkillMeterItem(
                icon = Icons.Default.Router,
                title = "Computer Networking",
                progress = networking,
                percentage = "8%",
                color = Color(0xFFFF9800),
                textColor = textPrimaryColor
            )

            SkillMeterItem(
                icon = Icons.Default.Handyman,
                title = "General Tech Skills",
                progress = generalSkills,
                percentage = "7%",
                color = Color(0xFF9C27B0),
                textColor = textPrimaryColor
            )

            SkillMeterItem(
                icon = Icons.Default.Extension,
                title = "Other",
                progress = other,
                percentage = "5%",
                color = Color(0xFF607D8B),
                textColor = textPrimaryColor
            )
        }
    }
}

@Composable
fun SkillMeterItem(
    icon: ImageVector,
    title: String,
    progress: Float,
    percentage: String,
    color: Color,
    textColor: Color
) {
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = ""
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    color = textColor
                )
            }
            Text(
                text = percentage,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color.copy(alpha = 0.15f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progressAnimation)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                color.copy(alpha = 0.7f),
                                color
                            )
                        )
                    )
            )
        }
    }
}
@Composable
fun TechExpertiseItem(
    icon: ImageVector,
    title: String,
    progress: Float,
    primaryColor: Color,
    textColor: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = primaryColor.copy(alpha = 0.1f),
                modifier = Modifier.size(36.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = primaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = textColor
            )

            Spacer(modifier = Modifier.weight(1f))

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = primaryColor.copy(alpha = 0.1f),
            ) {
                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium,
                    color = primaryColor,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = primaryColor,
            trackColor = primaryColor.copy(alpha = 0.2f),
            strokeCap = StrokeCap.Round
        )
    }
}

@Composable
fun ProfileInfoCard(
    primaryColor: Color,
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = surfaceColor)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "PERSONAL INFORMATION",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = textPrimaryColor,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            InfoRow(
                icon = Icons.Default.Email,
                label = "Email",
                value = "michelojustus@gmail.com",
                primaryColor = primaryColor,
                labelColor = textSecondaryColor,
                valueColor = textPrimaryColor
            )

            Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

            InfoRow(
                icon = Icons.Default.Phone,
                label = "Phone",
                value = "+260 77 0822 430",
                primaryColor = primaryColor,
                labelColor = textSecondaryColor,
                valueColor = textPrimaryColor
            )

            Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

            InfoRow(
                icon = Icons.Default.LocationOn,
                label = "Location",
                value = "Lusaka, Lusaka - Zambia",
                primaryColor = primaryColor,
                labelColor = textSecondaryColor,
                valueColor = textPrimaryColor
            )

            Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

            InfoRow(
                icon = Icons.Default.DateRange,
                label = "Date of birth",
                value = "December 25, ****",
                primaryColor = primaryColor,
                labelColor = textSecondaryColor,
                valueColor = textPrimaryColor
            )
        }
    }
}

@Composable
fun InfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    primaryColor: Color,
    labelColor: Color,
    valueColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = CircleShape,
            color = primaryColor.copy(alpha = 0.1f),
            modifier = Modifier.size(44.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = labelColor
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = valueColor
            )
        }
    }
}

@Composable
fun StatsSection(
    primaryColor: Color,
    secondaryColor: Color,
    accentColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val profiles = listOf(
            Triple("LinkedIn", "https://linkedin.com/in/amcodecase", Color(0xFF0A66C2)),
            Triple("Facebook", "https://www.facebook.com/people/Justus-Michelo/100087338261271/", Color(0xFF1877F2)),
            Triple("Twitter/X", "https://twitter.com/amcodecase", Color.Black),
            Triple("TikTok", "https://tiktok.com/@amcodecase", Color.Black)
        )

        profiles.forEach { (name, url, color) ->
            SocialProfileCard(
                networkName = name,
                color = color,
                textColor = Color.White,
                modifier = Modifier.weight(1f),
                onClick = { openUrl(context, url) }
            )
        }
    }
}

@Composable
fun SocialProfileCard(
    networkName: String,
    color: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(80.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when (networkName) {
                        "LinkedIn" -> Icons.Default.Person
                        "Facebook" -> Icons.Default.Facebook
                        "Twitter/X" -> Icons.Default.Info
                        "TikTok" -> Icons.Default.Star
                        else -> Icons.Default.Person
                    },
                    contentDescription = networkName,
                    tint = color,
                    modifier = Modifier.size(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = networkName,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor,
                maxLines = 1
            )
        }
    }
}

private fun openUrl(context: android.content.Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Composable
fun StatCard(
    title: String,
    subtitle: String,
    color: Color,
    textColor: Color,
    secondaryTextColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.aspectRatio(1f),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = color
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = secondaryTextColor,
                textAlign = TextAlign.Center
            )
        }
    }
}


data class TabItem(
    val title: String,
    val icon: ImageVector
)

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    AppEntryPoint()
}
@Composable
fun AwardsContent(
    primaryColor: Color,
    secondaryColor: Color,
    accentColor: Color,
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surfaceColor)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "MY ACHIEVEMENTS",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Award items in the requested order: 1, 4, 2, 3
                AwardItem(
                    title = "Outstanding Male ICT Student",
                    organization = "ICT Association of Zambia",
                    year = "2024",
                    location = "Mulungushi Int. Conference Center, Lusaka",
                    icon = Icons.Default.Star,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )

                Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

                AwardItem(
                    title = "3rd Position UNZA IEEE Expo",
                    organization = "UNZA IEEE Student Chapter",
                    year = "2024",
                    location = "UNZA Main Campus, Lusaka",
                    icon = Icons.Default.EmojiEvents,
                    primaryColor = accentColor,
                    additionalInfo = "ZMW 750 Cash Prize",
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )

                Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

                AwardItem(
                    title = "1st Position University ICT XPO",
                    organization = "ICT Association of Zambia @The 14th AGM",
                    year = "2023",
                    location = "Radisson Blu Hotel, Livingstone",
                    icon = Icons.Default.Work,
                    primaryColor = secondaryColor,
                    additionalInfo = "ZMW 21,000 Cash Prize",
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )

                Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

                AwardItem(
                    title = "1st Position Cyber Security Quiz",
                    organization = "Digital Safe Zambia Limited",
                    year = "2023",
                    location = "Mulungushi Int. Conference Center, Lusaka",
                    icon = Icons.Default.Security,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun AwardItem(
    title: String,
    organization: String,
    year: String,
    location: String,
    icon: ImageVector,
    primaryColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    additionalInfo: String? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = CircleShape,
            color = primaryColor.copy(alpha = 0.1f),
            modifier = Modifier.size(50.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.size(26.dp)
                )
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = textPrimaryColor
                )

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = primaryColor.copy(alpha = 0.1f),
                    modifier = Modifier
                        .padding(start = 4.dp)
                ) {
                    Text(
                        text = year,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = primaryColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Text(
                text = organization,
                style = MaterialTheme.typography.bodyMedium,
                color = textPrimaryColor
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = textSecondaryColor,
                    modifier = Modifier.size(14.dp)
                )

                Text(
                    text = location,
                    style = MaterialTheme.typography.bodySmall,
                    color = textSecondaryColor
                )
            }

            additionalInfo?.let {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null,
                        tint = primaryColor,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = primaryColor
                    )
                }
            }
        }
    }
}
@Composable
fun CareerContent(
    primaryColor: Color,
    secondaryColor: Color,
    accentColor: Color,
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Education section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surfaceColor)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "EDUCATION",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                EducationItem(
                    degree = "Bachelor's Degree in ICT with Education",
                    institution = "Chalimbana University",
                    period = "2020 - 2024",
                    status = "Pending Graduation",
                    location = "Chongwe",
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )
            }
        }

        // Work experience section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surfaceColor)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "WORK EXPERIENCE",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                ExperienceItem(
                    position = "Applications Developer",
                    company = "Zambia Qualifications Authority",
                    period = "November 2024 - May 2025",
                    type = "Internship",
                    location = "Lusaka",
                    icon = Icons.Default.Code,
                    primaryColor = secondaryColor,
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )

                Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

                ExperienceItem(
                    position = "ICT Tutor",
                    company = "Chalimbana University",
                    period = "September 2024 - July 2025",
                    type = "Volunteer",
                    location = "Chongwe",
                    icon = Icons.Default.School,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )

                Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

                ExperienceItem(
                    position = "Software Developer",
                    company = "Innovative Dynamics Limited",
                    period = "January - April 2024",
                    type = "Internship",
                    location = "Lusaka",
                    icon = Icons.Default.Computer,
                    primaryColor = accentColor,
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )

                Divider(color = textSecondaryColor.copy(alpha = 0.2f), thickness = 1.dp)

                ExperienceItem(
                    position = "Web Developer",
                    company = "Greentech Sustainable Engineering Solutions Limited",
                    period = "October 2022 - Present",
                    type = "Part-time",
                    location = "Lusaka",
                    icon = Icons.Default.Web,
                    primaryColor = Color(0xFF4CAF50), // Green color for Greentech
                    textPrimaryColor = textPrimaryColor,
                    textSecondaryColor = textSecondaryColor
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun EducationItem(
    degree: String,
    institution: String,
    period: String,
    status: String,
    location: String,
    primaryColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = CircleShape,
            color = primaryColor.copy(alpha = 0.1f),
            modifier = Modifier.size(50.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.size(26.dp)
                )
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = degree,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = textPrimaryColor
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = institution,
                    style = MaterialTheme.typography.bodyMedium,
                    color = textPrimaryColor
                )

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = primaryColor.copy(alpha = 0.1f),
                ) {
                    Text(
                        text = status,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = primaryColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = textSecondaryColor,
                    modifier = Modifier.size(14.dp)
                )

                Text(
                    text = period,
                    style = MaterialTheme.typography.bodySmall,
                    color = textSecondaryColor
                )

                Spacer(modifier = Modifier.width(12.dp))

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = textSecondaryColor,
                    modifier = Modifier.size(14.dp)
                )

                Text(
                    text = location,
                    style = MaterialTheme.typography.bodySmall,
                    color = textSecondaryColor
                )
            }
        }
    }
}

@Composable
fun ExperienceItem(
    position: String,
    company: String,
    period: String,
    type: String,
    location: String,
    icon: ImageVector,
    primaryColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = CircleShape,
            color = primaryColor.copy(alpha = 0.1f),
            modifier = Modifier.size(50.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.size(26.dp)
                )
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = position,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = textPrimaryColor
                )

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = primaryColor.copy(alpha = 0.1f),
                ) {
                    Text(
                        text = type,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = primaryColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Text(
                text = company,
                style = MaterialTheme.typography.bodyMedium,
                color = textPrimaryColor
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = textSecondaryColor,
                    modifier = Modifier.size(14.dp)
                )

                Text(
                    text = period,
                    style = MaterialTheme.typography.bodySmall,
                    color = textSecondaryColor
                )

                Spacer(modifier = Modifier.width(12.dp))

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = textSecondaryColor,
                    modifier = Modifier.size(14.dp)
                )

                Text(
                    text = location,
                    style = MaterialTheme.typography.bodySmall,
                    color = textSecondaryColor
                )
            }
        }
    }
}


@Composable
fun SkillsContent(
    primaryColor: Color,
    secondaryColor: Color,
    accentColor: Color,
    surfaceColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    isDarkTheme: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Software Development Services Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surfaceColor)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Code,
                        contentDescription = null,
                        tint = primaryColor,
                        modifier = Modifier.size(28.dp)
                    )

                    Text(
                        text = "Development Services",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = primaryColor
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Development Services as simple skill items with icons
                SimpleSkillItem(
                    skill = "Custom Website Development & CMS Integration",
                    icon = Icons.Outlined.Language,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Web Application Development",
                    icon = Icons.Outlined.Web,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Native Android Application Development",
                    icon = Icons.Outlined.PhoneAndroid,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Database Design & Optimization",
                    icon = Icons.Outlined.Storage,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "API Development & System Integration",
                    icon = Icons.Outlined.Api,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Custom Automation Solutions",
                    icon = Icons.Outlined.AutoFixHigh,
                    primaryColor = primaryColor,
                    textPrimaryColor = textPrimaryColor
                )
            }
        }

        // IT Infrastructure Services Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surfaceColor)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Dns,
                        contentDescription = null,
                        tint = secondaryColor,
                        modifier = Modifier.size(28.dp)
                    )

                    Text(
                        text = "IT Infrastructure Services",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = secondaryColor
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // IT Infrastructure Services
                SimpleSkillItem(
                    skill = "Network Architecture & Implementation",
                    icon = Icons.Outlined.SettingsEthernet,
                    primaryColor = secondaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "IT Security Assessments & Hardening",
                    icon = Icons.Outlined.Shield,
                    primaryColor = secondaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Enterprise Firewall Configuration",
                    icon = Icons.Outlined.Security,
                    primaryColor = secondaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "VPN & Remote Access Solutions",
                    icon = Icons.Outlined.VpnLock,
                    primaryColor = secondaryColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Network Monitoring & Management",
                    icon = Icons.Outlined.MonitorHeart,
                    primaryColor = secondaryColor,
                    textPrimaryColor = textPrimaryColor
                )
            }
        }

        // Professional Services Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surfaceColor)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = null,
                        tint = accentColor,
                        modifier = Modifier.size(28.dp)
                    )

                    Text(
                        text = "Professional Services",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Professional Services
                SimpleSkillItem(
                    skill = "Technical Training & Master Classes",
                    icon = Icons.Outlined.CastForEducation,
                    primaryColor = accentColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "One-on-One Mentoring",
                    icon = Icons.Outlined.PersonPin,
                    primaryColor = accentColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Corporate Team Building",
                    icon = Icons.Outlined.Groups,
                    primaryColor = accentColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Technical Consulting",
                    icon = Icons.Outlined.AssignmentTurnedIn,
                    primaryColor = accentColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Talent Development",
                    icon = Icons.Outlined.Stars,
                    primaryColor = accentColor,
                    textPrimaryColor = textPrimaryColor
                )

                SimpleSkillItem(
                    skill = "Digital Forensics (Data Recovery)",
                    icon = Icons.Outlined.FindInPage,
                    primaryColor = accentColor,
                    textPrimaryColor = textPrimaryColor
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun SimpleSkillItem(
    skill: String,
    icon: ImageVector,
    primaryColor: Color,
    textPrimaryColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = primaryColor,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = skill,
            style = MaterialTheme.typography.bodyLarge,
            color = textPrimaryColor
        )
    }
}

@Composable
fun SkillItem(
    skill: String,
    progress: Float,
    primaryColor: Color,
    textPrimaryColor: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = skill,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = textPrimaryColor
            )

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = primaryColor.copy(alpha = 0.1f),
            ) {
                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium,
                    color = primaryColor,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = primaryColor,
            trackColor = primaryColor.copy(alpha = 0.2f),
            strokeCap = StrokeCap.Round
        )
    }
}