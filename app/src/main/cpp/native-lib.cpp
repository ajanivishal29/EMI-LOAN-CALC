#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_loainstantemi_easyemiloancalculator_emicalculatoroperamapps_gamedis_GetAppService_updateAppData(
        JNIEnv *env, jclass clazz) {
    // TODO: implement updateAppData()
    return env->NewStringUTF("localadservice/updatedownloadcount.php");

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_loainstantemi_easyemiloancalculator_emicalculatoroperamapps_gamedis_retrofit_APIClient_baseurl(
        JNIEnv *env, jclass clazz) {
    // TODO: implement baseurl()
    return env->NewStringUTF("https://mtlmedia.xyz/");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_loainstantemi_easyemiloancalculator_emicalculatoroperamapps_gamedis_GetAppService_fetchdatastring(
        JNIEnv *env, jclass clazz) {
    // TODO: implement fetchdatastring()
    return env->NewStringUTF("adservice/get_Opera_Mapps.php");

}