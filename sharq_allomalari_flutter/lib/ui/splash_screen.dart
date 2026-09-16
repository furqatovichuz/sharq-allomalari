import 'package:flutter/material.dart';

import '../theme/app_theme.dart';
import 'main_screen.dart';

/// Ilova ishga tushganda qisqa muddat ko'rsatiladigan boshlang'ich ekran
/// (Android'dagi `SplashActivity` + `androidx.core.splashscreen` ekvivalenti).
class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    Future.delayed(const Duration(milliseconds: 900), () {
      if (!mounted) return;
      Navigator.of(
        context,
      ).pushReplacement(MaterialPageRoute(builder: (_) => const MainScreen()));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.primary,
      body: Center(
        child: Image.asset(
          'assets/images/Logo.png',
          width: 160,
          height: 160,
        ),
      ),
    );
  }
}
