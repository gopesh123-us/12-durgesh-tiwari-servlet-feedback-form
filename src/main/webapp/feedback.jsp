<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta
	name="viewport"
	content="width=device-width, initial-scale=1"
>
<%@ include file="components/links.jsp"%>
<title>Feedback Form</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="content_container d-flex flex-column justify-content-start align-items-center mt-5">
		<h1 class="text-center py-4 mb-4">Fill the feedback form</h1>
		<!-- start of form -->
		<form
			action="<%=application.getContextPath()%>/processFeedback"
			method="POST"
		>

			<!-- email field -->
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">
					Email address
				</label>
				<input
					name="email"
					placeholder="Enter email"
					type="email"
					class="form-control"
					id="exampleInputEmail1"
					aria-describedby="emailHelp">
				<div
					id="emailHelp"
					class="form-text text-white"
				>We'll never share your email with anyone else.</div>
			</div>

			<!-- phone number field -->
			<div class="mb-3">
				<label
					for="exampleInputPassword1"
					class="form-label"
				>Phone Number</label> <input
					name="phone"
					placeholder="Enter phone number"
					type=text
					class="form-control"
					id="exampleInputPassword1"
				>
			</div>
			<div class="mb-3">
				<label
					for="exampleInputPassword1"
					class="form-label"
				>Your feedback message</label>
				<textarea
					rows="8"
					class="form-control"
					name="feedback_message"
					placeholder="Enter message here"
					class="form-control"
					id="exampleInputPassword1"
				></textarea>
			</div>
			<!-- submit button -->
			<div class="d-grid gap-2">
				<button
					type="submit"
					class="btn btn-warning"
				>Submit</button>
				<button
					type="reset"
					class="btn btn-primary"
				>Reset</button>
			</div>
		</form>
		<!-- end of form -->
	</div>
	<%@ include file="components/scripts.jsp"%>
</body>
</html>