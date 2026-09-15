import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:sharq_allomalari_flutter/main.dart';

void main() {
  testWidgets('Splash screen shows and app boots', (WidgetTester tester) async {
    await tester.pumpWidget(const SharqAllomalariApp());
    await tester.pump();
    expect(find.byType(Scaffold), findsOneWidget);

    // Let the splash screen's navigation timer fire so no timer is left
    // pending when the test tears down.
    await tester.pump(const Duration(milliseconds: 900));
    await tester.pumpAndSettle();
  });
}
