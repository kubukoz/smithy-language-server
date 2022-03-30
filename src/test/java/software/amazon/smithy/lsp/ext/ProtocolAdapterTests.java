/*
 * Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.smithy.lsp;

import org.eclipse.lsp4j.Diagnostic;
import static software.amazon.smithy.model.validation.Severity.WARNING;
import software.amazon.smithy.model.validation.ValidationEvent;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProtocolAdapterTests {
	@Test
	public void addIdToDiagnostic() throws Exception {
		final ValidationEvent vEvent = ValidationEvent.builder()
			.message("Ooops")
			.id("should-show-up")
			.severity(WARNING)
			.build();
		final Diagnostic actual = ProtocolAdapter.toDiagnostic(vEvent);
		assertEquals("Ooops - should-show-up", actual.getMessage());
	}
}
