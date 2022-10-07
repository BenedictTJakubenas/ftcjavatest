package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@Autonomous

public class auto extends LinearOpMode {
    private DcMotor RF;
    private DcMotor RB;
    private DcMotor LF;
    private DcMotor LB;



    static final double tpr = 537.7;
    static final double tpi = tpr / (4 * 3.14159265359);


    @Override
    public void runOpMode() throws InterruptedException {
        RF = hardwareMap.dcMotor.get("rightFront");
        RB = hardwareMap.dcMotor.get("rightBack");
        LF = hardwareMap.dcMotor.get("leftFront");
        LB = hardwareMap.dcMotor.get("leftBack");

        RF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        RF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LB.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        RF.setTargetPosition((int)(tpi * 36));
        RB.setTargetPosition((int)(tpi * 36));
        LF.setTargetPosition((int)(tpi * 36));
        LB.setTargetPosition((int)(tpi * 36));


        while(RF.getCurrentPosition() < RF.getTargetPosition() &&
                RB.getCurrentPosition() < RB.getTargetPosition() &&
                LF.getCurrentPosition() < LF.getTargetPosition() &&
                LB.getCurrentPosition() < LB.getTargetPosition()) {
            RF.setPower(1);
            RB.setPower(1);
            LF.setPower(1);
            LB.setPower(1);
        }
        RF.setPower(0);
        RB.setPower(0);
        LF.setPower(0);
        LB.setPower(0);







    }
}
