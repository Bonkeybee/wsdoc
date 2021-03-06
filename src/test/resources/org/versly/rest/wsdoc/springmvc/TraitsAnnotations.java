/**
 * This endpoint has private publication scope.
 */
package org.versly.rest.wsdoc.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.versly.rest.wsdoc.DocumentationTraits;

public class TraitsAnnotations {

    /**
     * A controller with all stable methods. 
     */
    public static class StableController {

        @RequestMapping(value = "/stable1", method = RequestMethod.GET)
        public void stable() {
        }
    }

    /**
     * A controller with all deprecated (implicit) methods.
     */
    @DocumentationTraits(DocumentationTraits.DEPRECATED)
    public static class DeprecatedController {

        @RequestMapping(value = "/deprecated2", method = RequestMethod.GET)
        public void deprecated() {
        }
    }

    /**
     * A controller with some stable, deprecated, experimental, and deprecated experimental methods.
     */
    public static class MixedController {

        @RequestMapping(value = "/stable3", method = RequestMethod.GET)
        public void stable() {
        }

        @DocumentationTraits(DocumentationTraits.DEPRECATED)
        @RequestMapping(value = "/deprecated3", method = RequestMethod.GET)
        public void deprecated() {
        }

        @DocumentationTraits(DocumentationTraits.EXPERIMENTAL)
        @RequestMapping(value = "/experimental3", method = RequestMethod.GET)
        public void experimental() {
        }

        @DocumentationTraits({ DocumentationTraits.DEPRECATED, DocumentationTraits.EXPERIMENTAL })
        @RequestMapping(value = "/experimentaldeprecated3", method = RequestMethod.GET)
        public void experimentaldeprecated() {
        }
    }
}
