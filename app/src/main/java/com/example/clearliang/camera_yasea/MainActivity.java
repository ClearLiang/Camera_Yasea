package com.example.clearliang.camera_yasea;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.faucamp.simplertmp.RtmpHandler;
import com.seu.magicfilter.utils.MagicFilterType;

import net.ossrs.yasea.SrsCameraView;
import net.ossrs.yasea.SrsEncodeHandler;
import net.ossrs.yasea.SrsPublisher;
import net.ossrs.yasea.SrsRecordHandler;

import java.io.IOException;
import java.net.SocketException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SrsEncodeHandler.SrsEncodeListener, RtmpHandler.RtmpListener, SrsRecordHandler.SrsRecordListener{
    private SrsCameraView mGlsurfaceviewCamera;
    private Button mBtnSwitch,mBtnTaken,mBtnVideo;

    private SrsPublisher mPublisher;
    private String rtmpUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initCamera();
    }

    private void initView() {
        mGlsurfaceviewCamera = findViewById(R.id.glsurfaceview_camera);
        mBtnSwitch = findViewById(R.id.btn_switch);
        mBtnTaken = findViewById(R.id.btn_taken);
        mBtnVideo = findViewById(R.id.btn_video);
    }

    private void initEvent() {
        mBtnSwitch.setOnClickListener(this);
        mBtnTaken.setOnClickListener(this);
        mBtnVideo.setOnClickListener(this);
        mGlsurfaceviewCamera.setOnClickListener(this);
    }

    private void initCamera() {
        mPublisher = new SrsPublisher(mGlsurfaceviewCamera);
        //编码状态回调
        mPublisher.setEncodeHandler(new SrsEncodeHandler(this));
        mPublisher.setRecordHandler(new SrsRecordHandler(this));
        //rtmp推流状态回调
        mPublisher.setRtmpHandler(new RtmpHandler(this));
        //预览分辨率
        mPublisher.setPreviewResolution(1280, 720);
        //推流分辨率
        mPublisher.setOutputResolution(720, 1280);
        //传输率
        mPublisher.setVideoHDMode();
        //开启美颜（其他滤镜效果在MagicFilterType中查看）
        mPublisher.switchCameraFilter(MagicFilterType.BEAUTY);
        //打开摄像头，开始预览（未推流）
        mPublisher.startCamera();
        //mPublisher.switchToSoftEncoder();//选择软编码
        mPublisher.switchToHardEncoder();//选择硬编码
        //开始推流 rtmpUrl（ip换成服务器的部署ip）："rtmp://192.168.31.126/android/teststream"
        //mPublisher.startPublish(rtmpUrl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_switch:
                mPublisher.switchCameraFace(Camera.CameraInfo.CAMERA_FACING_FRONT);
                break;
            case R.id.btn_taken:
                break;
            case R.id.btn_video:
                break;
            case R.id.glsurfaceview_camera:
                break;
            default:
                break;
        }
    }

    @Override
    public void onNetworkWeak() {

    }

    @Override
    public void onNetworkResume() {

    }

    @Override
    public void onEncodeIllegalArgumentException(IllegalArgumentException e) {

    }

    @Override
    public void onRecordPause() {

    }

    @Override
    public void onRecordResume() {

    }

    @Override
    public void onRecordStarted(String msg) {

    }

    @Override
    public void onRecordFinished(String msg) {

    }

    @Override
    public void onRecordIllegalArgumentException(IllegalArgumentException e) {

    }

    @Override
    public void onRecordIOException(IOException e) {

    }

    @Override
    public void onRtmpConnecting(String msg) {

    }

    @Override
    public void onRtmpConnected(String msg) {

    }

    @Override
    public void onRtmpVideoStreaming() {

    }

    @Override
    public void onRtmpAudioStreaming() {

    }

    @Override
    public void onRtmpStopped() {

    }

    @Override
    public void onRtmpDisconnected() {

    }

    @Override
    public void onRtmpVideoFpsChanged(double fps) {

    }

    @Override
    public void onRtmpVideoBitrateChanged(double bitrate) {

    }

    @Override
    public void onRtmpAudioBitrateChanged(double bitrate) {

    }

    @Override
    public void onRtmpSocketException(SocketException e) {

    }

    @Override
    public void onRtmpIOException(IOException e) {

    }

    @Override
    public void onRtmpIllegalArgumentException(IllegalArgumentException e) {

    }

    @Override
    public void onRtmpIllegalStateException(IllegalStateException e) {

    }









}
