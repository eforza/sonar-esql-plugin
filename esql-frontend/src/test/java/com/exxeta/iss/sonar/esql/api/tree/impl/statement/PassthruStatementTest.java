/*
 * Sonar ESQL Plugin
 * Copyright (C) 2013-2017 Thomas Pohl and EXXETA AG
 * http://www.exxeta.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.exxeta.iss.sonar.esql.api.tree.impl.statement;

import static com.exxeta.iss.sonar.esql.utils.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.exxeta.iss.sonar.esql.api.tree.Tree.Kind;
import com.exxeta.iss.sonar.esql.tree.impl.statement.PassthruStatementTreeImpl;
import com.exxeta.iss.sonar.esql.utils.EsqlTreeModelTest;

public class PassthruStatementTest extends EsqlTreeModelTest<PassthruStatementTreeImpl> {


	@Test
	public void passthruStatement(){
		assertThat(Kind.PASSTHRU_STATEMENT)
		.matches("PASSTHRU 'CREATE TABLE Shop.Customers (  CustomerNumber INTEGER,  FirstName      VARCHAR(256),  LastName       VARCHAR(256),  Street         VARCHAR(256),  City           VARCHAR(256),  Country        VARCHAR(256))' TO Database.DSN1;")
		.matches("PASSTHRU ('', '');")
		;
	}
	
	@Test
	public void modelTest() throws Exception{
		PassthruStatementTreeImpl tree = parse("PASSTHRU '' TO Database.DSN1 VALUES ();", Kind.PASSTHRU_STATEMENT);
		assertNotNull(tree);
		assertNotNull(tree.passthruKeyword());
		assertNotNull(tree.expression());
		assertNotNull(tree.toKeyword());
		assertNotNull(tree.databaseReference());
		assertNotNull(tree.valuesKeyword());
		assertNotNull(tree.expressionList());
		assertNotNull(tree.semi());
	}
	
	
	
}
 