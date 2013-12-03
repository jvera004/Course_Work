//  PROGRAMMER: Jonathan Vera
//  PANTHERID: 2677306
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Participation Assignment
//  DUE:            Monday 02/25/2013
//
//  Accel1ViewController.m
//  Accel1
//
//  Created by Steven Luis on 10/28/11.
//  Copyright 2011 FIU. All rights reserved.
//

#import "Accel1ViewController.h"

#define INTERVAL  0.03 // 30 measurements per second

//added a different interval to make it quicker
#define FASTER_INTERVAL 0.00001

#define NORMALIZE(x) (x+1.0)/2.0  // normalize accelerometer readings for progress bar: (-1..1) to (0..1)
#define STRINGF(x) [NSString stringWithFormat:@"%f", x] // convert a float to a string

#define XTAG 0 // UI objects that refer to accellerometer x values
#define YTAG 1 // UI objects that refer to accellerometer y values
#define ZTAG 2 // UI objects that refer to accellerometer z values

@implementation Accel1ViewController{
    //get the bounds of the screen to use for later
    CGRect screenBounds;
}
@synthesize progressBar;
@synthesize labelValues;
@synthesize movingButtonOutlet;


- (void)dealloc
{
    [movingButtonOutlet release];
    [progressBar release];
    [labelValues release];
    [super dealloc];
}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

/*
// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];

}
*/

- (void)viewDidUnload
{
    [self setMovingButtonOutlet:nil];
    [self setProgressBar:nil];
    [self setLabelValues:nil];
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return YES;
}

#pragma mark - Overide ViewController Delegate Methods

-(void) viewWillAppear: (BOOL) animated {
    
    [super viewWillAppear: (BOOL) animated];
     
     NSLog (@"Monitoring accelerometer");
    UIAccelerometer *myAccel = [UIAccelerometer sharedAccelerometer ];
    
    [myAccel setUpdateInterval: INTERVAL];
    [myAccel setDelegate:self];
    
    //obtain the screen bounds
    screenBounds.size.width = self.view.bounds.size.width;
    screenBounds.size.height = self.view.bounds.size.height;
}

- (void) viewDidDisappear:(BOOL)animated {
    [super viewWillDisappear:animated];
    [[UIAccelerometer sharedAccelerometer] setDelegate:nil];
    
}

#pragma mark - Get Accelerometer data

- (void) accelerometer:(UIAccelerometer *)accelerometer didAccelerate:(UIAcceleration *)acceleration {
    
//    NSLog (@" %f %f %f", [acceleration x], [acceleration y], [acceleration z]);
    
    //Reset the interval so it doesn't do it at the faster speed
    [accelerometer setUpdateInterval: INTERVAL];
    
    for (UIProgressView * thisBar in progressBar) {
        switch (thisBar.tag) {
            case XTAG : 
                thisBar.progress = NORMALIZE([acceleration x]);
                break;
            case YTAG:
                thisBar.progress = NORMALIZE([acceleration y]);
                break;
            case ZTAG:
                thisBar.progress = NORMALIZE([acceleration z]);
                break;
            default:
                break;
        }
    }
    
    for (UILabel *thisLabel in labelValues) {
        switch (thisLabel.tag) {
            case XTAG :
                thisLabel.text = STRINGF([acceleration x]);
                break;
            case YTAG :
                thisLabel.text = STRINGF([acceleration y]);
                break;
            case ZTAG:
                thisLabel.text = STRINGF([acceleration z]);
                break;
            
            default:
                break;
        }
    }
    
    //So this moves the button, but it doesn't take the tilt factor to make it faster
    CGPoint accelerationMovement = CGPointMake([acceleration x],[acceleration y]);

    //Testing to make the button move faster
    [accelerometer setUpdateInterval: FASTER_INTERVAL];
    
    //get the current position of the button
    CGRect newButtonLocation = movingButtonOutlet.frame;
    
    //subtract and add the values to the button's origin to move in a natural way
    newButtonLocation.origin.y -= accelerationMovement.y * 10;
    newButtonLocation.origin.x += accelerationMovement.x * 10;
    
    //if the current location is at the bounds and more reverse the position so it doesn't move offscreen
    if(newButtonLocation.origin.x >= screenBounds.size.width || newButtonLocation.origin.x <= screenBounds.origin.x){
        newButtonLocation.origin.x =  (newButtonLocation.origin.x - (screenBounds.size.width)) * -1;
    }
    if(newButtonLocation.origin.y >= screenBounds.size.height || newButtonLocation.origin.y <= screenBounds.origin.y){
        newButtonLocation.origin.y = (newButtonLocation.origin.y - (screenBounds.size.height)) * -1;
    }

    //animate the movement
    [UIView animateWithDuration: .9 animations:^{ movingButtonOutlet.frame = newButtonLocation; }];
}

// For moving the button by touch only
- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    
    CGPoint touchLocation = [[touches anyObject] locationInView:self.view];
    
    CGRect newButtonPressLocation = movingButtonOutlet.frame;
    
    newButtonPressLocation.origin.y = touchLocation.y;
    newButtonPressLocation.origin.x = touchLocation.x;
    
    [UIView animateWithDuration:0.5 animations:^{
        movingButtonOutlet.frame = newButtonPressLocation;
    }];
}

- (void)touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event

{
    NSLog(@"moved");
    CGPoint touchLocation = [[touches anyObject] locationInView:self.view];
    
    CGRect newButtonPressLocation = movingButtonOutlet.frame;
    
    newButtonPressLocation.origin.y = touchLocation.y;
    newButtonPressLocation.origin.x = touchLocation.x;
    
    [UIView animateWithDuration:0.5 animations:^{
        movingButtonOutlet.frame = newButtonPressLocation;
    }];
    
}

@end
