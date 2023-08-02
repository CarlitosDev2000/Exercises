funetes para hacer mi alert dialog:
@NonNull
public AlertDialog create() {
// We can't use Dialog's 3-arg constructor with the createThemeContextWrapper param,
// so we always have to re-set the theme
final AlertDialog dialog = new AlertDialog(P.mContext, mTheme);
P.apply(dialog.mAlert);
dialog.setCancelable(P.mCancelable);
if (P.mCancelable) {
dialog.setCanceledOnTouchOutside(true);
}
dialog.setOnCancelListener(P.mOnCancelListener);
dialog.setOnDismissListener(P.mOnDismissListener);
if (P.mOnKeyListener != null) {
dialog.setOnKeyListener(P.mOnKeyListener);
}
return dialog;
}
https://stackoverflow.com/questions/15762905/how-can-i-display-a-list-view-in-an-android-alert-dialog
fuentes para escribir solo con caracteres o solo con numeros:
https://www.freecodecamp.org/espanol/news/cadena-de-java-a-int-como-convertir-una-cadena-en-un-numero-entero/
aprender hacer toast
https://stackoverflow.com/questions/66831709/how-to-have-a-toast-appear-on-a-if-else-statements-on-android-studio
linea 87 Toast.class
https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=es-419
https://www.tutorialesprogramacionya.com/javaya/androidya/detalleconcepto.php?codigo=166&inicio=