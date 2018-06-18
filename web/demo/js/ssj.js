//showFPS.setParentElementId("info");
//showFPS.go();
var table = [
    "H", "hcp", "Hydrogen", 1, 1, "rgba(255,255,51,",
    "He", "hcp", "Helium", 18, 1, "rgba(153,255,204,",
    "Li", "bcc", "Lithium", 1, 2, "rgba(255,255,51,",
    "Be", "hcp", "Beryllium", 2, 2, "rgba(255,255,51,",
    "B", "hcp", "Boron", 13, 2, "rgba(255,51,153,",
    "C", "hcp", "Carbon", 14, 2, "rgba(255,51,153,",
    "N", "hcp", "Nitrogen", 15, 2, "rgba(255,51,153,",
    "O", "hcp", "Oxygen", 16, 2, "rgba(255,51,153,",
    "F", "", "Fluorine", 17, 2, "rgba(255,51,153,",
    "Ne", "fcc", "Neon", 18, 2, "rgba(153,255,204,",
    "Na", "bcc", "Sodium", 1, 3, "rgba(255,255,51,",
    "Mg", "hcp", "Magnesium", 2, 3, "rgba(255,255,51,",
    "Al", "fcc", "Aluminium", 13, 3, "rgba(51,153,255,",
    "Si", "diamand", "Silicon", 14, 3, "rgba(255,51,153,",
    "P", "cubic", "Phosphorus", 15, 3, "rgba(255,51,153,",
    "S", "cubic", "Sulfur", 16, 3, "rgba(255,51,153,",
    "Cl", "tetragonal", "Chlorine", 17, 3, "rgba(255,51,153,",
    "Ar", "fcc", "Argon", 18, 3, "rgba(153,255,204,",
    "K", "bcc", "Potassium", 1, 4, "rgba(255,255,51,",
    "Ca", "fcc", "Calcium", 2, 4, "rgba(255,255,51,",
    "Sc", "hcp", "Scandium", 3, 4, "rgba(51,153,255,",
    "Ti", "hcp", "Titanium", 4, 4, "rgba(51,153,255,",
    "V", "bcc", "Vanadium", 5, 4, "rgba(51,153,255,",
    "Cr", "bcc", "Chromium", 6, 4, "rgba(51,153,255,",
    "Mn", "cubic", "Manganese", 7, 4, "rgba(51,153,255,",
    "Fe", "fcc", "Iron", 8, 4, "rgba(51,153,255,",
    "Co", "hcp", "Cobalt", 9, 4, "rgba(51,153,255,",
    "Ni", "fcc", "Nickel", 10, 4, "rgba(51,153,255,",
    "Cu", "fcc", "Copper", 11, 4, "rgba(51,153,255,",
    "Zn", "hcp", "Zinc", 12, 4, "rgba(51,153,255,",
    "Ga", "cubic", "Gallium", 13, 4, "rgba(51,153,255,",
    "Ge", "diamand", "Germanium", 14, 4, "rgba(51,153,255,",
    "As", "trigonal", "Arsenic", 15, 4, "rgba(255,51,153,",
    "Se", "hcp", "Selenium", 16, 4, "rgba(255,51,153,",
    "Br", "cubic", "Bromine", 17, 4, "rgba(255,51,153,",
    "Kr", "fcc", "Krypton", 18, 4, "rgba(153,255,204,",
    "Rb", "bcc", "Rubidium", 1, 5, "rgba(255,255,51,",
    "Sr", "fcc", "Strontium", 2, 5, "rgba(255,255,51,",
    "Y", "hcp", "Yttrium", 3, 5, "rgba(51,153,255,",
    "Zr", "hcp", "Zirconium", 4, 5, "rgba(51,153,255,",
    "Nb", "bcc", "Niobium", 5, 5, "rgba(51,153,255,",
    "Mo", "bcc", "Molybdenum", 6, 5, "rgba(51,153,255,",
    "Tc", "", "Technetium", 7, 5, "rgba(51,153,255,",
    "Ru", "hcp", "Ruthenium", 8, 5, "rgba(51,153,255,",
    "Rh", "fcc", "Rhodium", 9, 5, "rgba(51,153,255,",
    "Pd", "fcc", "Palladium", 10, 5, "rgba(51,153,255,",
    "Ag", "fcc", "Silver", 11, 5, "rgba(51,153,255,",
    "Cd", "hcp", "Cadmium", 12, 5, "rgba(51,153,255,",
    "In", "tetragonal", "Indium", 13, 5, "rgba(51,153,255,",
    "Sn", "tetragonal", "Tin", 14, 5, "rgba(51,153,255,",
    "Sb", "trigonal", "Antimony", 15, 5, "rgba(51,153,255,",
    "Te", "hcp", "Tellurium", 16, 5, "rgba(255,51,153,",
    "I", "cubic", "Iodine", 17, 5, "rgba(255,51,153,",
    "Xe", "fcc", "Xenon", 18, 5, "rgba(153,255,204,",
    "Cs", "bcc", "Caesium", 1, 6, "rgba(255,255,51,",
    "Ba", "bcc", "Barium", 2, 6, "rgba(255,255,51,",
    "La", "hcp", "Lanthanum", 4, 8.5, "rgba(51,153,255,",
    "Ce", "fcc", "Cerium", 5, 8.5, "rgba(51,153,255,",
    "Pr", "hcp", "Praseodymium", 6, 8.5, "rgba(51,153,255,",
    "Nd", "hcp", "Neodymium", 7, 8.5, "rgba(51,153,255,",
    "Pm", "hcp", "Promethium", 8, 8.5, "rgba(51,153,255,",
    "Sm", "trigonal", "Samarium", 9, 8.5, "rgba(51,153,255,",
    "Eu", "bcc", "Europium", 10, 8.5, "rgba(51,153,255,",
    "Gd", "hcp", "Gadolinium", 11, 8.5, "rgba(51,153,255,",
    "Tb", "hcp", "Terbium", 12, 8.5, "rgba(51,153,255,",
    "Dy", "hcp", "Dysprosium", 13, 8.5, "rgba(51,153,255,",
    "Ho", "hcp", "Holmium", 14, 8.5, "rgba(51,153,255,",
    "Er", "hcp", "Erbium", 15, 8.5, "rgba(51,153,255,",
    "Tm", "hcp", "Thulium", 16, 8.5, "rgba(51,153,255,",
    "Yb", "fcc", "Ytterbium", 17, 8.5, "rgba(51,153,255,",
    "Lu", "hcp", "Lutetium", 18, 8.5, "rgba(51,153,255,",
    "Hf", "hcp", "Hafnium", 4, 6, "rgba(51,153,255,",
    "Ta", "bcc", "Tantalum", 5, 6, "rgba(51,153,255,",
    "W", "bcc", "Tungsten", 6, 6, "rgba(51,153,255,",
    "Re", "hcp", "Rhenium", 7, 6, "rgba(51,153,255,",
    "Os", "hcp", "Osmium", 8, 6, "rgba(51,153,255,",
    "Ir", "fcc", "Iridium", 9, 6, "rgba(51,153,255,",
    "Pt", "fcc", "Platinum", 10, 6, "rgba(51,153,255,",
    "Au", "fcc", "Gold", 11, 6, "rgba(51,153,255,",
    "Hg", "trigonal", "Mercury", 12, 6, "rgba(51,153,255,",
    "Tl", "hcp", "Thallium", 13, 6, "rgba(51,153,255,",
    "Pb", "fcc", "Lead", 14, 6, "rgba(51,153,255,",
    "Bi", "trigonal", "Bismuth", 15, 6, "rgba(51,153,255,",
    "Po", "monoclinic", "Polonium", 16, 6, "rgba(51,153,255,",
    "At", "", "Astatine", 17, 6, "rgba(255,51,153,",
    "Rn", "fcc", "Radon", 18, 6, "rgba(153,255,204,",
    "Fr", "bcc", "Francium", 1, 7, "rgba(255,255,51,",
    "Ra", "", "Radium", 2, 7, "rgba(255,255,51,",
    "Ac", "", "Actinium", 4, 9.5, "rgba(51,153,255,",
    "Th", "fcc", "Thorium", 5, 9.5, "rgba(51,153,255,",
    "Pa", "", "Protactinium", 6, 9.5, "rgba(51,153,255,",
    "U", "cubic", "Uranium", 7, 9.5, "rgba(51,153,255,",
    "Np", "", "Neptunium", 8, 9.5, "rgba(51,153,255,",
    "Pu", "", "Plutonium", 9, 9.5, "rgba(51,153,255,",
    "Am", "", "Americium", 10, 9.5, "rgba(51,153,255,",
    "Cm", "", "Curium", 11, 9.5, "rgba(51,153,255,",
    "Bk", "", "Berkelium", 12, 9.5, "rgba(51,153,255,",
    "Cf", "", "Californium", 13, 9.5, "rgba(51,153,255,",
    "Es", "", "Einstenium", 14, 9.5, "rgba(51,153,255,",
    "Fm", "", "Fermium", 15, 9.5, "rgba(51,153,255,",
    "Md", "", "Mendelevium", 16, 9.5, "rgba(51,153,255,",
    "No", "", "Nobelium", 17, 9.5, "rgba(51,153,255,",
    "Lr", "", "Lawrencium", 18, 9.5, "rgba(51,153,255,",
    "Rf", "", "Rutherfordium", 4, 7, "rgba(51,153,255,",
    "Db", "", "Dubnium", 5, 7, "rgba(51,153,255,",
    "Sg", "", "Seaborgium", 6, 7, "rgba(51,153,255,",
    "Bh", "", "Bohrium", 7, 7, "rgba(51,153,255,",
    "Hs", "", "Hassium", 8, 7, "rgba(51,153,255,",
    "Mt", "", "Meitnerium", 9, 7, "rgba(51,153,255,",
    "Ds", "", "Darmstadium", 10, 7, "rgba(51,153,255,",
    "Rg", "", "Roentgenium", 11, 7, "rgba(51,153,255,",
    "Cn", "", "Copernicium", 12, 7, "rgba(51,153,255,",
    "Uut", "", "Unutrium", 13, 7, "rgba(51,153,255,",
    "Fl", "", "Flerovium", 14, 7, "rgba(51,153,255,",
    "Uup", "", "Ununpentium", 15, 7, "rgba(51,153,255,",
    "Lv", "", "Livermorium", 16, 7, "rgba(51,153,255,",
    "Uus", "", "Ununseptium", 17, 7, "rgba(51,153,255,",
    "Uuo", "", "Ununoctium", 18, 7 ,"rgba(153,255,204,"
];

var camera, scene, renderer;
var controls;

var objects = [];
var targets = { table: [], sphere: [], helix: [], grid: [] };

var ifxz = true;

var winHeigth = window.innerHeight;

init();
animate();
setTimeout(clickDShere, 10);
setTimeout(clickGrid,  3000);
setTimeout(clickTable, 10100);
//setTimeout(clickTable, 12000);

function init() {

	camera = new THREE.PerspectiveCamera( 40, window.innerWidth / winHeigth, 1, 10000 );
	//设置透视投影的相机,默认情况下相机的上方向为Y轴，右方向为X轴，沿着Z轴朝里（视野角：fov 纵横比：aspect 相机离视体积最近的距离：near 相机离视体积最远的距离：far）
	camera.position.z = 3500;
	////设置相机的位置坐标
	scene = new THREE.Scene();
	//设置场景
	// table
	for ( var i = 0; i < table.length; i += 6 ) {

		var element = document.createElement( 'div' );
		//创建元素
		element.className = 'element';
		element.style.color = table[ i + 5 ] + 1 + ")"
		var number = document.createElement( 'div' );
		number.className = 'number';
		number.textContent = (i/6) + 1;
		element.appendChild( number );
		//用createElement()函数创建元素 
		//用setAttribute()函数设置属性值

		var symbol = document.createElement( 'div' );
		symbol.className = 'symbol';
		symbol.textContent = table[ i ];
		element.appendChild( symbol );
		//插入节点

		var details = document.createElement( 'div' );
		details.className = 'details';
		details.innerHTML = table[ i + 1 ] ;
		element.appendChild( details );
        
		var struture = document.createElement('div');
		struture.className = 'struture';
		struture.innerHTML = table[ i + 2 ] ;
		var object = new THREE.CSS3DObject( element );
		element.appendChild( struture );
		
		//头像平贴平面
		object.position.x = Math.random() * 4000 - 2000;//随机位置
		object.position.y = Math.random() * 4000 - 2000;
		object.position.z = Math.random() * 4000 - 2000;
		scene.add( object );
		//用于向场景中添加对象

		objects.push( object );

		var object = new THREE.Object3D();
		object.position.x = ( table[ i + 3 ] * 170 ) - 1600;
		object.position.y = - ( table[ i + 4 ] * 180 ) + 890;
		targets.table.push( object );
}

		// sphere

var vector = new THREE.Vector3();
var spherical = new THREE.Spherical();

for ( var i = 0, l = objects.length; i < l; i ++ ) {

	var phi = Math.acos( -1 + ( 2 * i ) / l );
	var theta = Math.sqrt( l * Math.PI ) * phi;

	var object = new THREE.Object3D();

	spherical.set( 800, phi, theta );

	object.position.setFromSpherical( spherical );

	vector.copy( object.position ).multiplyScalar( 2 );

	object.lookAt( vector );

	targets.sphere.push( object );

}

		// helix

	var vector = new THREE.Vector3();
	var cylindrical = new THREE.Cylindrical();

	for ( var i = 0, l = objects.length; i < l; i ++ ) {

		var theta = i * 0.275 + Math.PI;
		var y = - ( i * 8 ) + 450;

		var object = new THREE.Object3D();

		// 参数一 圈的大小 参数二 左右间距 参数三 上下间距
		cylindrical.set( 750, theta, y );

		object.position.setFromCylindrical( cylindrical );

		vector.x = object.position.x * 2;
		vector.y = object.position.y;
		vector.z = object.position.z * 2;

		object.lookAt( vector );

		targets.helix.push( object );

	}

	// grid

	for ( var i = 0; i < objects.length; i ++ ) {

		var object = new THREE.Object3D();

		object.position.x = ( ( i % 5 ) * 400 ) - 800; // 400 图片的左右间距  800 x轴中心店
		object.position.y = ( - ( Math.floor( i / 5 ) % 5 ) * 300 ) + 500;  // 500 y轴中心店
		object.position.z = ( Math.floor( i / 25 ) ) * 400 - 800;// 300调整 片间距 800z轴中心店
		targets.grid.push( object );
	}
	//渲染
	renderer = new THREE.CSS3DRenderer();
	renderer.setSize( window.innerWidth, winHeigth );
	renderer.domElement.style.position = 'absolute';
	document.getElementById( 'container' ).appendChild( renderer.domElement );

	// 鼠标控制
	controls = new THREE.TrackballControls( camera, renderer.domElement );
	//controls.rotateSpeed = 0.5;
	//controls.minDistance = 500;
	//controls.maxDistance = 6000;
	controls.addEventListener( 'change', render );

	var button = document.getElementById( 'table' );
	button.addEventListener( 'click', function ( event ) {
		transform( targets.table, 1000 );
	}, false );

	var button = document.getElementById( 'sphere' );
	button.addEventListener( 'click', function ( event ) {
		transform( targets.sphere, 2000 );
	}, false );

	var button = document.getElementById( 'helix' );
	button.addEventListener( 'click', function ( event ) {
		transform( targets.helix, 2000 );
	}, false );

	var button = document.getElementById( 'grid' );
	button.addEventListener( 'click', function ( event ) {
		transform( targets.grid, 2000 );
	}, false );

	window.addEventListener( 'resize', onWindowResize, false );
}

function transform( targets, duration, fun) {

	TWEEN.removeAll();

	for ( var i = 0; i < objects.length; i ++ ) {

		var object = objects[ i ];
		var target = targets[ i ];

		new TWEEN.Tween( object.position )
			.to( { x: target.position.x, y: target.position.y, z: target.position.z }, Math.random() * duration + duration )
			.easing( TWEEN.Easing.Exponential.InOut )
			.start();

		new TWEEN.Tween( object.rotation )
			.to( { x: target.rotation.x, y: target.rotation.y, z: target.rotation.z }, Math.random() * duration + duration )
			.easing( TWEEN.Easing.Exponential.InOut )
			.start();

	}

	new TWEEN.Tween( this )
		.to( {}, duration * 2 )
		.onUpdate( render )
		.start();
		if(fun)
		fun();
}
function onWindowResize() {
	camera.aspect = window.innerWidth / winHeigth;
	camera.updateProjectionMatrix();

	renderer.setSize( window.innerWidth, winHeigth );

	render();
}
function clickDShere(){document.getElementById( 'sphere' ).click();}  
function clickHelix(){document.getElementById( 'helix' ).click();}  
function clickGrid(){document.getElementById( 'grid' ).click();}  
function clickTable(){
	ifxz = false;
	document.getElementById( 'table' ).click();
}

function animate() {
	// 让场景通过x轴或者y轴旋转  & z
	if(!ifxz){
		scene.rotation.y = 0;
	}else{
		scene.rotation.y += 0.005;
	}		
	requestAnimationFrame( animate );

	TWEEN.update();

	controls.update();

	// 渲染循环
	render();
}
function render() {

	renderer.render( scene, camera );

}
