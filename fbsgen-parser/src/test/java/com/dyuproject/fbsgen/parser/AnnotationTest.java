//========================================================================
//Copyright 2007-2010 David Yu dyuproject@gmail.com
//------------------------------------------------------------------------
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at 
//http://www.apache.org/licenses/LICENSE-2.0
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//========================================================================

package com.dyuproject.fbsgen.parser;

import java.io.File;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

/**
 * Tests for annotations on messages, enums, fields, services, rpc methods, extensions
 * 
 * @author David Yu
 * @created Dec 30, 2010
 */
public class AnnotationTest extends TestCase
{
    @SuppressWarnings("unchecked")
    static void verifySubList(List<Object> subList)
    {
        assertEquals(3, subList.size());
        
        assertEquals(Integer.valueOf(4), subList.get(0));
        assertEquals(Boolean.FALSE, subList.get(1));
        
        Map<String, Object> subMap = (Map<String, Object>)subList.get(2);
        assertEquals(1, subMap.size());
        assertEquals(Boolean.TRUE, subMap.get("five"));
    }
    
    @SuppressWarnings("unchecked")
    static void verifySubMap(Map<String, Object> subMap)
    {
        assertEquals(2, subMap.size());
        verifySubList((List<Object>)subMap.get("four"));
        
        Map<String, Object> map = (Map<String, Object>)subMap.get("five");
        assertEquals(1, map.size());
        verifySubList((List<Object>)map.get("four"));
    }
    
    @SuppressWarnings("unchecked")
    static void verifyList(Annotation a)
    {
        assertNotNull(a);
        assertTrue(a.params.containsKey("test"));
        List<Object> list = a.getValue("test");
        assertEquals(5, list.size());
        
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Boolean.TRUE, list.get(1));
        assertEquals("3", list.get(2));
        
        List<Object> subList = (List<Object>)list.get(3);
        verifySubList(subList);
        
        Map<String, Object> subMap = (Map<String, Object>)list.get(4);
        verifySubMap(subMap);
    }
    
    @SuppressWarnings("unchecked")
    static void verifyMap(Annotation a)
    {
        assertNotNull(a);
        assertTrue(a.params.containsKey("test"));
        Map<String, Object> map = a.getValue("test");
        assertEquals(5, map.size());
        
        assertEquals(Integer.valueOf(1), map.get("one"));
        assertEquals(Boolean.TRUE, map.get("two"));
        assertEquals("3", map.get("three"));
        
        List<Object> subList = (List<Object>)map.get("four");
        verifySubList(subList);
        
        Map<String, Object> subMap = (Map<String, Object>)map.get("five");
        verifySubMap(subMap);
    }
    
    public void testIt() throws Exception
    {
        File f = ProtoParserTest.getFile("com/dyuproject/fbsgen/parser/test_annotations.proto");
        assertTrue(f.exists());

        Proto proto = new Proto(f);
        ProtoUtil.loadFrom(f, proto);

        Message person = proto.getMessage("Person");
        assertNotNull(person);
        assertTrue(person.isSequentialFieldNumbers());
        
        verifyList(person.getAnnotation("List"));
        verifyMap(person.getAnnotation("Map"));

        Annotation defaultPerson = person.getAnnotation("DefaultPerson");
        assertNotNull(defaultPerson);
        assertEquals("Anonymous Coward", defaultPerson.getValue("name"));
        
        assertEquals(1, person.getComments().size());
        assertEquals("DefaultPerson", person.getComments().get(0));

        Field<?> age = person.getField("age");
        assertNotNull(age);

        Annotation defaultAge = age.getAnnotation("DefaultAge");
        assertNotNull(defaultAge);
        assertTrue(defaultAge.getParams().isEmpty());
        
        assertEquals(1, age.getComments().size());
        assertEquals("DefaultAge", age.getComments().get(0));

        EnumGroup gender = person.getNestedEnumGroup("Gender");
        assertNotNull(gender);

        Annotation defaultGender = gender.getAnnotation("DefaultGender");
        assertEquals("MALE", defaultGender.getValue("value"));
        
        assertEquals(1, gender.getComments().size());
        assertEquals("DefaultGender", gender.getComments().get(0));

        EnumGroup.Value male = gender.getValue("MALE");
        assertNotNull(male);
        assertEquals(1, male.number);
        Annotation maleA = male.getAnnotation("Alias");
        assertNotNull(maleA);
        assertEquals("m", maleA.getValue("value"));
        assertTrue(person == maleA.getValue("type"));

        EnumGroup.Value female = gender.getValue("FEMALE");
        assertNotNull(female);
        assertEquals(2, female.number);
        Annotation femaleA = female.getAnnotation("Alias");
        assertNotNull(femaleA);
        assertEquals("f", femaleA.getValue("value"));
        assertTrue(person == femaleA.getValue("type"));

        Message listRequest = person.getNestedMessage("ListRequest");
        assertNotNull(listRequest);

        Annotation nestedMessageAnnotation = listRequest.getAnnotation("NestedMessageAnnotation");
        assertNotNull(nestedMessageAnnotation);
        assertTrue(nestedMessageAnnotation.getParams().isEmpty());
        
        assertEquals(1, listRequest.getComments().size());
        assertEquals("NestedMessageAnnotation", listRequest.getComments().get(0));

        Message response = listRequest.getNestedMessage("Response");
        assertNotNull(response);

        Annotation deeperMessageAnnotation = response.getAnnotation("DeeperMessageAnnotation");
        assertNotNull(deeperMessageAnnotation);
        assertTrue(deeperMessageAnnotation.getParams().isEmpty());
        
        assertEquals(1, response.getComments().size());
        assertEquals("DeeperMessageAnnotation", response.getComments().get(0));

        Field<?> personField = response.getField("person");
        assertNotNull(personField);

        Annotation deeperMessageFieldAnnotation = personField.getAnnotation("DeeperMessageFieldAnnotation");
        assertNotNull(deeperMessageFieldAnnotation);
        assertTrue(deeperMessageFieldAnnotation.getParams().size() == 2);
        assertEquals(false, deeperMessageFieldAnnotation.getValue("nullable"));
        assertEquals(Float.valueOf(1.1f), deeperMessageFieldAnnotation.getValue("version"));

        assertEquals(1, personField.getComments().size());
        assertEquals("DeeperMessageFieldAnnotation", personField.getComments().get(0));
        
        Field<?> keyField = response.getField("key");
        assertNotNull(keyField);

        Annotation testNested = keyField.getAnnotation("TestNested");
        assertNotNull(testNested);
        assertTrue(person == testNested.getValue("type"));
        assertTrue(gender == testNested.getValue("g"));
        
        assertEquals(1, keyField.getComments().size());
        assertEquals("TestNested", keyField.getComments().get(0));

        /*Collection<Extension> extensions = proto.getExtensions();
        assertTrue(extensions.size() == 1);
        Extension extendPerson = extensions.iterator().next();
        assertNotNull(extendPerson);

        Annotation personExtras = extendPerson.getAnnotation("PersonExtras");
        assertNotNull(personExtras);
        assertTrue(personExtras.getParams().isEmpty());

        Field<?> country = extendPerson.getField("country");
        assertNotNull(country);

        Annotation validate = country.getAnnotation("Validate");
        assertNotNull(validate);
        assertTrue(validate.getParams().isEmpty());*/

        Service personService = proto.getService("PersonService");
        assertNotNull(personService);
        assertTrue(personService.getAnnotationMap().size() == 2);

        Annotation someServiceAnnotation = personService.getAnnotation("SomeServiceAnnotation");
        Annotation anotherServiceAnnotation = personService.getAnnotation("AnotherServiceAnnotation");

        assertTrue(someServiceAnnotation != null && someServiceAnnotation.getParams().isEmpty());
        assertTrue(anotherServiceAnnotation != null && anotherServiceAnnotation.getParams().isEmpty());

        assertEquals(1, personService.getComments().size());
        assertEquals("SomeServiceAnnotation", personService.getComments().get(0));
        
        Service.RpcMethod put = personService.getRpcMethod("Put");
        assertNotNull(put);

        Annotation authRequired = put.getAnnotation("AuthRequired");
        assertNotNull(authRequired);
        assertTrue(authRequired.getParams().size() == 1);
        assertEquals("admin", authRequired.getValue("role"));
        
        assertEquals(1, put.getComments().size());
        assertEquals("AuthRequired", put.getComments().get(0));

        Service.RpcMethod list = personService.getRpcMethod("List");
        assertNotNull(list);

        Annotation testRpc = list.getAnnotation("TestRpc");
        assertNotNull(testRpc);
        assertTrue(person == testRpc.getValue("type"));
        assertTrue(gender == testRpc.getValue("g"));
        
        assertEquals(1, list.getComments().size());
        assertEquals("TestRpc", list.getComments().get(0));
    }

}
