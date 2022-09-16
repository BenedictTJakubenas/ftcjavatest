package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@TeleOp
public class TeleOp9_16_2022 extends OpMode {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;

    @Override
    public void init() {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftfront motor direction because flipped
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftback motor direction because flipped

        telemetry.addLine("Initialized");
    }

    @Override
    public void loop() {
        double rlrs = gamepad1.right_stick_x;
        leftFront.setPower(-gamepad1.left_stick_y);
        leftBack.setPower(-gamepad1.left_stick_y);
        rightFront.setPower(-gamepad1.left_stick_y);
        rightBack.setPower(-gamepad1.left_stick_y);

        //turn right
        while(rlrs > 0) {
            leftFront.setPower(-gamepad1.right_stick_x);
            leftBack.setPower(-gamepad1.right_stick_x);
            rightFront.setPower(gamepad1.right_stick_x);
            rightBack.setPower(gamepad1.right_stick_x);
        }
        //turn left
        while(rlrs < 0) {
            leftFront.setPower(gamepad1.right_stick_x);
            leftBack.setPower(gamepad1.right_stick_x);
            rightFront.setPower(-gamepad1.right_stick_x);
            rightBack.setPower(-gamepad1.right_stick_x);
        }



        telemetry.addData("LeftFront Power", leftFront.getPower());
        telemetry.addData("LeftBack Power", leftBack.getPower());
        telemetry.addData("RightFront Power", rightFront.getPower());
        telemetry.addData("RightBack Power", rightBack.getPower());
        telemetry.update();
    }
}
