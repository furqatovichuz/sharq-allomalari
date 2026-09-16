import 'package:firebase_analytics/firebase_analytics.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:firebase_crashlytics/firebase_crashlytics.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

import 'firebase_options.dart';
import 'theme/app_theme.dart';
import 'ui/splash_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  if (kIsWeb) {
    runApp(const SharqAllomalariApp());
    return;
  }

  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);

  FlutterError.onError = FirebaseCrashlytics.instance.recordFlutterFatalError;
  PlatformDispatcher.instance.onError = (error, stack) {
    FirebaseCrashlytics.instance.recordError(error, stack, fatal: true);
    return true;
  };

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
      navigatorObservers: kIsWeb
          ? const []
          : [FirebaseAnalyticsObserver(analytics: FirebaseAnalytics.instance)],
      home: const SplashScreen(),
    );
  }
}
