/* =========================================================================================
 * Copyright © 2013-2017 the kamon project <http://kamon.io/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 * =========================================================================================
 */

package kamon
package metric

import java.time.Duration

trait MetricLookup {

  def histogram(name: String): HistogramMetric =
    histogram(name, MeasurementUnit.none, None)

  def histogram(name: String, unit: MeasurementUnit): HistogramMetric =
    histogram(name, unit, None)

  def histogram(name: String, unit: MeasurementUnit, dynamicRange: DynamicRange): HistogramMetric =
    histogram(name, unit, Some(dynamicRange))


  def timer(name: String): TimerMetric =
    timer(name, None)

  def timer(name: String, dynamicRange: DynamicRange): TimerMetric =
    timer(name, Some(dynamicRange))


  def counter(name: String): CounterMetric =
    counter(name, MeasurementUnit.none)


  def gauge(name: String): GaugeMetric =
    gauge(name, MeasurementUnit.none)


  def rangeSampler(name: String): RangeSamplerMetric =
    rangeSampler(name, MeasurementUnit.none, None, None)

  def rangeSampler(name: String, unit: MeasurementUnit): RangeSamplerMetric =
    rangeSampler(name, unit, None, None)

  def rangeSampler(name: String, unit: MeasurementUnit, sampleInterval: Duration): RangeSamplerMetric =
    rangeSampler(name, unit, Option(sampleInterval), None)

  def rangeSampler(name: String, unit: MeasurementUnit, sampleInterval: Duration, dynamicRange: DynamicRange): RangeSamplerMetric =
    rangeSampler(name, unit, Option(sampleInterval), Option(dynamicRange))


  def histogram(name: String, unit: MeasurementUnit, dynamicRange: Option[DynamicRange]): HistogramMetric

  def timer(name: String, dynamicRange: Option[DynamicRange]): TimerMetric

  def counter(name: String, unit: MeasurementUnit): CounterMetric

  def gauge(name: String, unit: MeasurementUnit): GaugeMetric

  def rangeSampler(name: String, unit: MeasurementUnit, sampleInterval: Option[Duration], dynamicRange: Option[DynamicRange]): RangeSamplerMetric
}
