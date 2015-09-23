# example-toolbar-animation
An example Android project to show how to animate changing the toolbar and status bar colors with a circular reveal effect.

![Example of the Effect](http://i.stack.imgur.com/NpVCi.gif)

See http://stackoverflow.com/questions/27872324/how-can-i-animate-the-color-change-of-the-statusbar-and-toolbar-like-the-new-ca

The general idea is to set your actionbar and status bar to transparent.  This will shift your actionbar up under the statusbar so you have to adjust the size and padding of the actionbar to compensate.  You then use a view behind it and `ViewAnimationUtils.createCircularReveal` to reveal the new background color.  You need one more view behind that to show the old background color as the middle view is revealing the new one.

###The Animation###
The animation requires:

* The transparent toolbar **actionbar** that covers the space of the regular actionbar and the statusbar. The hard-coded height, in this case, is 56dp (actionbar) + 24dp (statusbar) = 80dp.  You also need to set the top padding to 24dp to keep the actionbar content our from under the statusbar.
* A middle view (I'll call it the **reveal view**) that's the same size (80dp height) but just behind the actionbar. This will be the view the `ViewAnimationUtils.createCircularReveal` acts on.
* A bottom view (I'll call it the **reveal background** view) that's the same size as the reveal view but behind it. This view is there to show the old background color while the reveal view is revealing the new color on top of it.
