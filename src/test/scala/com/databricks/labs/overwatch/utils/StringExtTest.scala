package com.databricks.labs.overwatch.utils

import com.databricks.labs.overwatch.SparkSessionTestWrapper
import com.databricks.labs.overwatch.utils.StringExt.StringHelpers
import org.scalatest.funspec.AnyFunSpec

class StringExtTest extends AnyFunSpec with SparkSessionTestWrapper {

  describe("StringHelpers Test") {
    it("Simple String Test No Special Characters") {
      assert("abc".containsNoSpecialChars == true)
    }

    it("String with only _") {
      assert("abc_xyz".containsNoSpecialChars == true)
    }

    it("String with Period") {
      assert("abc.xyz".containsNoSpecialChars == false)
    }

    it("String with special characters") {
      assert("abc_\\\\xyz".containsNoSpecialChars == false)
    }

  }
}