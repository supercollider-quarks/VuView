// 06/2006 blackrain at realizedsound dot net

VuView : SCUserView  {
	var <value=0;

	*viewClass { ^SCUserView }
	init { arg parent, bounds;
		super.init(parent, bounds);
		this.relativeOrigin_(false);
	}	
	draw {
		// frame
		Color.black.alpha_(0.4).set;
		Pen.width = 2;
		Pen.moveTo(this.bounds.left @ (this.bounds.top + this.bounds.height));
		Pen.lineTo(this.bounds.left @ this.bounds.top);
		Pen.lineTo((this.bounds.left + this.bounds.width) @ this.bounds.top);
		Pen.stroke;

		Color.white.alpha_(0.4).set;
		Pen.moveTo(this.bounds.left @ (this.bounds.top + this.bounds.height));
		Pen.lineTo((this.bounds.left + this.bounds.width) @ (this.bounds.top +
			this.bounds.height));
		Pen.lineTo((this.bounds.left + this.bounds.width) @ this.bounds.top);
		Pen.stroke;

		// center
		Color.black.alpha_(0.2).set;
		Pen.addWedge(this.bounds.center.x @ (this.bounds.top + this.bounds.height - 1), 
			this.bounds.height * 0.20, 0, -pi);
		Pen.perform(\fill);

		// scale
		Color.black.alpha_(0.2).set;
		Pen.addAnnularWedge(this.bounds.center.x @
			(this.bounds.top + this.bounds.height - 1), 
			this.bounds.height * 0.8, this.bounds.height * 0.95, -0.75pi, 0.5pi);
		Pen.perform(\fill);

		// dial
		Color.black(0.8, 0.8).set;
		Pen.width = 1;
		Pen.moveTo(this.bounds.center.x @ (this.bounds.top + this.bounds.height - 1));
		Pen.lineTo(Polar.new(this.bounds.height * 0.95, 
			[-0.75pi, -0.25pi, \linear].asSpec.map(value)).asPoint +
				(this.bounds.center.x @ (this.bounds.top + this.bounds.height)));
		Pen.stroke;
	}

	value_ { arg val;
		value = val;
		this.refresh;
	}
}
