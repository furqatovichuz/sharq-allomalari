import 'package:flutter/material.dart';

import 'theme/app_theme.dart';
import 'ui/splash_screen.dart';

void main() {
  runApp(const SharqAllomalariApp());
}

class SharqAllomalariApp extends StatelessWidget {
  const SharqAllomalariApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Sharq Allomalari',
      debugShowCheckedModeBanner: false,
      theme: AppTheme.light,
      home: const SplashScreen(),
    );
  }
}
