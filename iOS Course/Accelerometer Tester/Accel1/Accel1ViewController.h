//  PROGRAMMER: Jonathan Vera
//  PANTHERID: 2677306
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Participation Assignment
//  DUE:            Monday 02/25/2013
//
//  Accel1ViewController.h
//  Accel1
//
//  Created by Steven Luis on 10/28/11.
//  Copyright 2011 FIU. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface Accel1ViewController : UIViewController <UIAccelerometerDelegate> {
    
    UIButton *movingButtonOutlet;
    
    NSArray *progressBar;
    NSArray *labelValues;

}


- (void) viewWillAppear: (BOOL) animated;

- (void) viewDidDisappear:(BOOL) animated;

- (void) accelerometer:(UIAccelerometer *)accelerometer didAccelerate:(UIAcceleration *)acceleration;

@property (nonatomic, retain) IBOutletCollection(UIProgressView) NSArray *progressBar;

@property (nonatomic, retain) IBOutletCollection(UILabel) NSArray *labelValues;

@property (nonatomic, retain) IBOutlet UIButton *movingButtonOutlet;

@end
