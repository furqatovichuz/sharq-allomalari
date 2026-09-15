import 'package:flutter/widgets.dart';
import 'package:flutter_svg/flutter_svg.dart';

/// `app:tint` bilan bir xil ikonani turli rangda qayta ishlatish uchun
/// yordamchi widget (Android'dagi tint mexanizmining ekvivalenti).
class SvgIcon extends StatelessWidget {
  const SvgIcon(this.asset, {super.key, this.size = 20, this.color});

  final String asset;
  final double size;
  final Color? color;

  @override
  Widget build(BuildContext context) {
    return SvgPicture.asset(
      asset,
      width: size,
      height: size,
      colorFilter: color == null
          ? null
          : ColorFilter.mode(color!, BlendMode.srcIn),
    );
  }
}
