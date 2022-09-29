package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class teleop extends OpMode {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private CRServo liftarm;
    private DcMotor lift;

    @Override
    public void init() {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        liftarm = hardwareMap.crservo.get("liftarm");
        lift = hardwareMap.dcMotor.get("lift");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftfront motor direction because flipped
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftback motor direction because flipped

        telemetry.addLine("Initialized");
    }

    @Override
    public void loop() {
        //gamepad1
        double lsx = gamepad1.left_stick_x;
        double lsy = gamepad1.left_stick_y;
        double rsx = gamepad1.right_stick_x;
        double rsy = gamepad1.right_stick_y;


        //turn right
        if (Math.abs(rsx) > 0.05) {
            leftFront.setPower(gamepad1.right_stick_x);
            leftBack.setPower(gamepad1.right_stick_x);
            rightFront.setPower(-gamepad1.right_stick_x);
            rightBack.setPower(-gamepad1.right_stick_x);
        } else {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }
        if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)) {
            leftFront.setPower(-gamepad1.left_stick_y * 2);
            leftBack.setPower(-gamepad1.left_stick_y * 2);
            rightFront.setPower(-gamepad1.left_stick_y * 2);
            rightBack.setPower(-gamepad1.left_stick_y * 2);
        }   else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            rightFront.setPower(-gamepad1.left_stick_x);
            rightBack.setPower(gamepad1.left_stick_x);
            leftFront.setPower(gamepad1.left_stick_x);
            leftBack.setPower(-gamepad1.left_stick_x);
        } else {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }
       /* if (Math.abs(rsx) < 0.05 && Math.abs(rsy) < 0.05 && Math.abs(lsx) < 0.05 && Math.abs(lsy) < 0.05) {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }*/




        //gamepad2

        if (gamepad2.dpad_down) {
            liftarm.setPower(gamepad2.right_stick_y);
        } else {
            liftarm.setPower(0);
        }
        if (Math.abs(gamepad2.left_stick_y) > 0.05) {
            lift.setPower(gamepad2.left_stick_y);
        } else
        {
            lift.setPower(0);
        }





        telemetry.addData("LeftFront Power", leftFront.getPower());
        telemetry.addData("LeftBack Power", leftBack.getPower());
        telemetry.addData("RightFront Power", rightFront.getPower());
        telemetry.addData("RightBack Power", rightBack.getPower());
        telemetry.addData("lift Power", lift.getPower());
        telemetry.addData("liftarm power", liftarm.getPower());

        telemetry.update();
    }
}
