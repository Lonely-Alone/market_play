//overlay class, 这个就是弹出框的白色半透明背景层
var Overlay = new Class({
	Implements: [Options, Events],
	getOptions: function() {
		return {
			useFx: false,
			name:'',
			duration: 200,
			colour: '#000',
			opacity: 0.8,
			zIndex: 99,
			container: document.body,
			onClick: $empty
		};
	},

	initialize: function(options) {
		this.setOptions(this.getOptions(), options);
		this.options.container = $(this.options.container);

		this.container = new Element('div').attr('id', this.options.name+'_overlay').css({
			position: 'absolute',
			left: '0',
			top: '0',
			width: '100%',
			minWidth: '980px',
			height: '100%',
			backgroundColor: this.options.colour,
			zIndex: this.options.zIndex,
			opacity: this.options.opacity,
			filter:'alpha(opacity='+this.options.opacity * 100+')'
		}).inject(this.options.container);
		
		this.options.useFx ? this.fade = new Fx.Tween(this.container, { property: 'opacity', duration: this.options.duration }).set(0) : this.fade = null;
		this.container.setStyle('display', 'none');

		this.container.addEvent('click', function() {
			this.fireEvent('click');
		} .bind(this));
		window.addEvent('resize', this.position.bind(this));
		return this.position();
	},

	position: function() {
		if (this.options.container == document.body) {
			var h = window.getScrollHeight() + 'px';
			this.container.setStyles({ top: '0px', height: h });
		} else {
			var myCoords = this.options.container.getCoordinates();
			this.container.setStyles({
				top: myCoords.top + 'px',
				height: myCoords.height + 'px',
				left: myCoords.left + 'px',
				width: myCoords.width + 'px'
			});
		}
	},
	//调用此方法可以直接显示黑色半透明的覆盖层，默认层级99，opacity为0.8
	show: function() { 
		this.container.setStyle('display', '');
		if (this.fade) this.fade.cancel().start(this.options.opacity);
		return this.position();
	},

	hide: function(dispose) {
		if (this.fade) this.fade.cancel().start(0);
		this.container.setStyle('display', 'none');
		if (dispose) this.dispose();
		return this;
	},

	dispose: function() {
		this.container.dispose();
	}

});