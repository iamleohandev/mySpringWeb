<%@include file="common/include.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {
		$(".panel_content").hide();

		$("#first_content").show();

		//toggle the componenet with class msg_body
		$(".panel_heading").click(function() {
			$(this).next(".panel_content").slideToggle(500);
		});

	});
</script>

<div class="body">

	<div class="panel_layer">

		<p class="panel_heading">Header-1</p>
		<div id="first_content" class="panel_content">Lorem ipsum dolor
			sit amet, consectetuer adipiscing elit orem ipsum dolor sit amet,
			consectetuer adipiscing elit</div>


		<p class="panel_heading">Header-2</p>
		<div class="panel_content">Lorem ipsum dolor sit amet,
			consectetuer adipiscing elit orem ipsum dolor sit amet, consectetuer
			adipiscing elit</div>




		<p class="panel_heading">Header-3</p>
		<div class="panel_content">Lorem ipsum dolor sit amet,
			consectetuer adipiscing elit orem ipsum dolor sit amet, consectetuer
			adipiscing elit</div>


	</div>


</div>

